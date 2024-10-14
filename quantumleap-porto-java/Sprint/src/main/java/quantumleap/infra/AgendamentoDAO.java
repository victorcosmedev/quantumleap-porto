package quantumleap.infra;

import quantumleap.dominio.Agendamento;
import quantumleap.dominio.Diagnostico;
import quantumleap.dominio.Oficina;
import quantumleap.dominio.RepositorioAgentamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgendamentoDAO implements RepositorioAgentamento {

    private Connection conexao;

    public AgendamentoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO tb_qfx_agendamento (id_diagnostico, id_oficina, data_agendamento, hora_agendamento, descricao_agendamento) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql, new String[] {"id_agendamento"})) {
            pstmt.setLong(1, agendamento.getDiagnostico().getIdDiagnostico());
            pstmt.setLong(2, agendamento.getOficina().getIdOficina());
            pstmt.setString(3, agendamento.getData());
            pstmt.setString(4, agendamento.getHora());
            pstmt.setString(5, agendamento.getDiagnostico().getDescricao());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    agendamento.setIdAgendamento(generatedKeys.getLong(1));
                } else {
                    throw new SQLException();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean verificarConflitoAgendamento(String data, String hora) {
        String sql = "SELECT COUNT(*) FROM tb_qfx_agendamento WHERE data_agendamento = ? AND hora_agendamento = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, data);
            pstmt.setString(2, hora);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }


    public Agendamento buscarAgendamentoPorId(long idAgendamento) {
        String sql = "SELECT * FROM tb_qfx_agendamento WHERE id_agendamento = ?";
        Agendamento agendamento = null;
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idAgendamento);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    long idDiagnostico = rs.getLong("id_diagnostico");
                    long idOficina = rs.getLong("id_oficina");
                    String dataAgendamento = rs.getString("data_agendamento");
                    String horaAgendamento = rs.getString("hora_agendamento");
                    String descricaoAgendamento = rs.getString("descricao_agendamento");

                    DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
                    Diagnostico diagnostico = diagnosticoDAO.buscarDiagnosticoPorId(idDiagnostico);

                    OficinaDAO oficinaDAO = new OficinaDAO();
                    Oficina oficina = oficinaDAO.buscarOficinaPorId(idOficina);

                    agendamento = new Agendamento(diagnostico, dataAgendamento, horaAgendamento, oficina);
                    agendamento.setIdAgendamento(idAgendamento);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return agendamento;
    }



    public void atualizarAgendamento(long idAgendamento, Agendamento agendamento) {
        String sql = "UPDATE tb_qfx_agendamento SET data_agendamento = ?, hora_agendamento = ?, descricao_agendamento = ? WHERE id_agendamento = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, agendamento.getData());
            pstmt.setString(2, agendamento.getHora());
            pstmt.setString(3, agendamento.getDiagnostico().getDescricao());
            pstmt.setLong(4, idAgendamento);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deletarAgendamento(Long idAgendamento) {
        String sql = "DELETE FROM tb_qfx_agendamento WHERE id_agendamento = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idAgendamento);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Agendamento> listarAgendamentos() {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT id_agendamento, id_diagnostico, id_oficina, data_agendamento, hora_agendamento, descricao_agendamento FROM tb_qfx_agendamento";


        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
        OficinaDAO oficinaDAO = new OficinaDAO();

        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                long idAgendamento = rs.getLong("id_agendamento");
                long idDiagnostico = rs.getLong("id_diagnostico");
                long idOficina = rs.getLong("id_oficina");
                String dataAgendamento = rs.getString("data_agendamento");
                String horaAgendamento = rs.getString("hora_agendamento");

                Diagnostico diagnostico = diagnosticoDAO.buscarDiagnosticoPorId(idDiagnostico);
                Oficina oficina = oficinaDAO.buscarOficinaPorId(idOficina);

                Agendamento agendamento = new Agendamento(diagnostico, dataAgendamento, horaAgendamento, oficina);
                agendamento.setIdAgendamento(idAgendamento);
                agendamentos.add(agendamento);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return agendamentos;
    }

    public void fecharConexao(){
        try{
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}