package quantumleap.infra.dao;

import quantumleap.dominio.Agendamento;
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

        String sqlAgendamento = "INSERT INTO tb_qfx_agendamento (id_diagnostico, id_oficina, data_agendamento, hora_agendamento, descricao_agendamento) VALUES (?, ?, ?, ?, ?)";


        String sqlDescricaoProblema = "SELECT pe.descricao_problema " +
                "FROM tb_qfx_diagnostico d " +
                "JOIN tb_qfx_problemas_existentes pe ON d.id_problema = pe.id_problema " +
                "WHERE d.id_diagnostico = ?";

        try (PreparedStatement pstmtDesc = conexao.prepareStatement(sqlDescricaoProblema)) {
            pstmtDesc.setLong(1, agendamento.getIdDiagnostico());
            String descricaoProblema = null;
            try (ResultSet rs = pstmtDesc.executeQuery()) {
                if (rs.next()) {
                    descricaoProblema = rs.getString("descricao_problema");
                }
            }
            if (descricaoProblema != null) {
                try (PreparedStatement pstmt = conexao.prepareStatement(sqlAgendamento, new String[] {"id_agendamento"})) {
                    pstmt.setLong(1, agendamento.getIdDiagnostico());
                    pstmt.setLong(2, agendamento.getIdOficina());
                    pstmt.setString(3, agendamento.getData());
                    pstmt.setString(4, agendamento.getHora());
                    pstmt.setString(5, descricaoProblema);

                    pstmt.executeUpdate();
                    pstmt.close();

                    try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            agendamento.setIdAgendamento(generatedKeys.getLong(1));
                        } else {
                            throw new SQLException("Falha ao obter o ID gerado do agendamento.");
                        }
                    }
                }
            } else {
                throw new SQLException("Nenhuma descrição encontrada para o problema associado ao diagnóstico.");
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
        String sql = "SELECT ag.id_agendamento, ag.id_diagnostico, ag.id_oficina, " +
                "ag.data_agendamento, ag.hora_agendamento, " +
                "pe.descricao_problema, o.localizacao_oficina " +
                "FROM tb_qfx_agendamento ag " +
                "JOIN tb_qfx_diagnostico d ON ag.id_diagnostico = d.id_diagnostico " +
                "JOIN tb_qfx_problemas_existentes pe ON d.id_problema = pe.id_problema " +
                "JOIN tb_qfx_oficina o ON ag.id_oficina = o.id_oficina " +
                "WHERE ag.id_agendamento = ?";

        Agendamento agendamento = null;
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idAgendamento);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    long idDiagnostico = rs.getLong("id_diagnostico");
                    long idOficina = rs.getLong("id_oficina");
                    String dataAgendamento = rs.getString("data_agendamento");
                    String horaAgendamento = rs.getString("hora_agendamento");
                    String descricaoProblema = rs.getString("descricao_problema");
                    String localizacaoOficina = rs.getString("localizacao_oficina");

                    agendamento = new Agendamento(idDiagnostico, dataAgendamento, horaAgendamento, idOficina);
                    agendamento.setIdAgendamento(idAgendamento);
                    agendamento.setDescricao_agendamento(descricaoProblema);
                    agendamento.setLocalizacao(localizacaoOficina);
                }
                pstmt.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return agendamento;
    }

    public void atualizarAgendamento(long idAgendamento, Agendamento agendamento) {
        String sqlAtualizar = "UPDATE tb_qfx_agendamento SET data_agendamento = ?, hora_agendamento = ?, descricao_agendamento = ?, id_diagnostico = ?, id_oficina = ? WHERE id_agendamento = ?";

        String sqlDescricaoProblema = "SELECT pe.descricao_problema " +
                "FROM tb_qfx_diagnostico d " +
                "JOIN tb_qfx_problemas_existentes pe ON d.id_problema = pe.id_problema " +
                "WHERE d.id_diagnostico = ?";

        String descricaoProblema = null;

     
        try (PreparedStatement pstmtDesc = conexao.prepareStatement(sqlDescricaoProblema)) {
            pstmtDesc.setLong(1, agendamento.getIdDiagnostico());
            try (ResultSet rs = pstmtDesc.executeQuery()) {
                if (rs.next()) {
                    descricaoProblema = rs.getString("descricao_problema");
                }
                pstmtDesc.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar descrição do problema: " + e.getMessage());
        }


        if (descricaoProblema != null) {
            try (PreparedStatement pstmt = conexao.prepareStatement(sqlAtualizar)) {
                pstmt.setString(1, agendamento.getData());
                pstmt.setString(2, agendamento.getHora());
                pstmt.setString(3, descricaoProblema);
                pstmt.setLong(4, agendamento.getIdDiagnostico());
                pstmt.setLong(5, agendamento.getIdOficina());
                pstmt.setLong(6, idAgendamento);


                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new SQLException("Nenhuma linha foi atualizada. ID do agendamento pode não existir: " + idAgendamento);
                } else {
                    System.out.println("Agendamento atualizado com sucesso!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao atualizar agendamento: " + e.getMessage());
            }
        }
    }

    public void deletarAgendamento(Long idAgendamento) {
        String sql = "DELETE FROM tb_qfx_agendamento WHERE id_agendamento = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idAgendamento);
            pstmt.executeUpdate();
            pstmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Agendamento> listarAgendamentos() {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT ag.id_agendamento, ag.id_diagnostico, ag.id_oficina, " +
                "ag.data_agendamento, ag.hora_agendamento, " +
                "pe.descricao_problema, o.localizacao_oficina " +
                "FROM tb_qfx_agendamento ag " +
                "JOIN tb_qfx_diagnostico d ON ag.id_diagnostico = d.id_diagnostico " +
                "JOIN tb_qfx_problemas_existentes pe ON d.id_problema = pe.id_problema " +
                "JOIN tb_qfx_oficina o ON ag.id_oficina = o.id_oficina";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                long idAgendamento = rs.getLong("id_agendamento");
                long idDiagnostico = rs.getLong("id_diagnostico");
                long idOficina = rs.getLong("id_oficina");
                String dataAgendamento = rs.getString("data_agendamento");
                String horaAgendamento = rs.getString("hora_agendamento");
                String descricaoProblema = rs.getString("descricao_problema");
                String localizacaoOficina = rs.getString("localizacao_oficina");

                Agendamento agendamento = new Agendamento(idDiagnostico, dataAgendamento, horaAgendamento, idOficina);
                agendamento.setIdAgendamento(idAgendamento);
                agendamento.setDescricao_agendamento(descricaoProblema);
                agendamento.setLocalizacao(localizacaoOficina);
                agendamentos.add(agendamento);

            }
            pstmt.close();

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