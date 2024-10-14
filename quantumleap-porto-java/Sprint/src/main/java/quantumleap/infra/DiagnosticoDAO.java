package quantumleap.infra;

import quantumleap.dominio.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiagnosticoDAO {

    private Connection conexao;

    public DiagnosticoDAO() {

        this.conexao = new ConnectionFactory().getConnection();

    }

    public void adicionarDiagnostico(Diagnostico diagnostico) {
        String sql = "INSERT INTO tb_qfx_diagnostico (id_cliente, id_veiculo, id_problema, id_guincho) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql, new String[] {"id_diagnostico"})) {
            pstmt.setLong(1, diagnostico.getCliente().getIdCliente());
            pstmt.setLong(2, diagnostico.getVeiculo().getIdVeiculo());
            pstmt.setLong(3, diagnostico.getProblemasExistentes().getIdProblemas());
            pstmt.setLong(4, diagnostico.getGuincho().getIdGuincho());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    diagnostico.setIdDiagnostico(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao obter o ID gerado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Diagnostico buscarDiagnosticoPorId(Long idDiagnostico) {
        Diagnostico diagnostico = null;
        String sql = "SELECT * FROM tb_qfx_diagnostico WHERE id_diagnostico = ?";
        ClienteDAO clienteDAO = new ClienteDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        ProblemasExistentesDAO problemasExistentesDAO = new ProblemasExistentesDAO();
        GuinchoDAO guinchoDAO = new GuinchoDAO();

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idDiagnostico);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = clienteDAO.buscarClientePorId(rs.getLong("id_cliente"));
                    Veiculo veiculo = veiculoDAO.buscarVeiculoPorId(rs.getLong("id_veiculo"));
                    ProblemasExistentes problemasExistentes = problemasExistentesDAO.buscarProblemasExistentesPorId(rs.getLong("id_problema"));
                    Guincho guincho = guinchoDAO.buscarGuinchoPorId(rs.getLong("id_guincho"));

                    diagnostico = new Diagnostico(cliente, veiculo, problemasExistentes, guincho);
                    diagnostico.setIdDiagnostico(idDiagnostico);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnostico;
    }


    public void atualizarDiagnostico(long idDiagnostico, Diagnostico novoDiagnostico) {
        String sql = "UPDATE tb_qfx_diagnostico SET id_cliente = ?, id_veiculo = ?, id_problema = ?, id_guincho = ? WHERE id_diagnostico = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, novoDiagnostico.getCliente().getIdCliente());
            pstmt.setLong(2, novoDiagnostico.getVeiculo().getIdVeiculo());
            pstmt.setLong(3, novoDiagnostico.getProblemasExistentes().getIdProblemas());
            pstmt.setLong(4, novoDiagnostico.getGuincho().getIdGuincho());
            pstmt.setLong(5, idDiagnostico);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarDiagnostico(Long idDiagnostico) {
        String sql = "DELETE FROM tb_qfx_diagnostico WHERE id_diagnostico = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idDiagnostico);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Diagnostico> listarDiagnosticos() {
        ArrayList<Diagnostico> diagnosticos = new ArrayList<>();
        String sql = "SELECT id_diagnostico, id_cliente, id_veiculo, id_problema, id_guincho FROM tb_qfx_diagnostico";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                long idDiagnostico = rs.getLong("id_diagnostico");
                long clienteId = rs.getLong("id_cliente");
                long veiculoId = rs.getLong("id_veiculo");
                long problemasExistentesId = rs.getLong("id_problema");
                long guinchoId = rs.getLong("id_guincho");

                Cliente cliente = new ClienteDAO().buscarClientePorId(clienteId);
                Veiculo veiculo = new VeiculoDAO().buscarVeiculoPorId(veiculoId);
                ProblemasExistentes problemasExistentes = new ProblemasExistentesDAO().buscarProblemaPorId(problemasExistentesId);
                Guincho guincho = new GuinchoDAO().buscarGuinchoPorId(guinchoId);
                Diagnostico diagnostico = new Diagnostico(cliente, veiculo, problemasExistentes, guincho);
                diagnostico.setIdDiagnostico(idDiagnostico);
                diagnosticos.add(diagnostico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnosticos;
    }

    public void fecharConexao(){
        try{
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
