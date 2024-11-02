package quantumleap.infra.dao;

import quantumleap.dominio.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiagnosticoDAO implements RepositorioDiagnostico{

    private Connection conexao;

    public DiagnosticoDAO() {

        this.conexao = new ConnectionFactory().getConnection();

    }

    public void adicionarDiagnostico(Diagnostico diagnostico) {
        String sql = "INSERT INTO tb_qfx_diagnostico (id_cliente, id_veiculo, id_problema, id_guincho) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql, new String[] {"id_diagnostico"})) {
            pstmt.setLong(1, diagnostico.getIdCliente());
            pstmt.setLong(2, diagnostico.getIdVeiculo());
            pstmt.setLong(3, diagnostico.getIdProblemasExistentes());
            pstmt.setLong(4, diagnostico.getIdGuincho());
            pstmt.executeUpdate();
            pstmt.close();

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

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idDiagnostico);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    diagnostico = new Diagnostico(
                            rs.getLong("id_cliente"),
                            rs.getLong("id_veiculo"),
                            rs.getLong("id_problema"),
                            rs.getLong("id_guincho")
                    );
                    diagnostico.setIdDiagnostico(idDiagnostico);
                }
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diagnostico;
    }

    public void atualizarDiagnostico(long idDiagnostico, Diagnostico novoDiagnostico) {
        String sql = "UPDATE tb_qfx_diagnostico SET id_cliente = ?, id_veiculo = ?, id_problema = ?, id_guincho = ? WHERE id_diagnostico = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, novoDiagnostico.getIdCliente());
            pstmt.setLong(2, novoDiagnostico.getIdVeiculo());
            pstmt.setLong(3, novoDiagnostico.getIdProblemasExistentes());
            pstmt.setLong(4, novoDiagnostico.getIdGuincho());
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

                Diagnostico diagnostico = new Diagnostico(clienteId, veiculoId, problemasExistentesId, guinchoId);
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
