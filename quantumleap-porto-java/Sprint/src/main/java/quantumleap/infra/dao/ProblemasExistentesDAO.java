package quantumleap.infra.dao;

import quantumleap.dominio.ProblemasExistentes;
import quantumleap.dominio.RepositorioProblemasExistentes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemasExistentesDAO implements RepositorioProblemasExistentes {

    private Connection conexao;

    public ProblemasExistentesDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void adicionarProblemaExistente(ProblemasExistentes problema) {
        String sqlInsert = "INSERT INTO tb_qfx_problemas_existentes (id_peca, nome_problema, descricao_problema, custo_mao_de_obra_problema, qtd_peca) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement comandoInsercao = conexao.prepareStatement(sqlInsert, new String[] {"id_problema"})) {

            comandoInsercao.setLong(1, problema.getIdPeca());
            comandoInsercao.setString(2, problema.getNomeProblema());
            comandoInsercao.setString(3, problema.getDescricaoProblema());
            comandoInsercao.setDouble(4, problema.getCustoMaoDeObraProblema());
            comandoInsercao.setInt(5, problema.getQtdPeca());

            comandoInsercao.executeUpdate();

            try (ResultSet generatedKeys = comandoInsercao.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    problema.setIdProblemas(generatedKeys.getLong(1));
                } else {
                    throw new SQLException();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ProblemasExistentes buscarProblemaPorId(long idProblema) {
        ProblemasExistentes problema = null;
        String sql = "SELECT * FROM tb_qfx_problemas_existentes WHERE id_problema = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idProblema);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                    problema = new ProblemasExistentes(
                            rs.getString("nome_problema"),
                            rs.getString("descricao_problema"),
                            rs.getDouble("custo_mao_de_obra_problema"),
                            rs.getInt("qtd_peca"),
                            rs.getLong("id_peca")
                    );
                    problema.setIdProblemas(rs.getLong("id_problema"));
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problema;
    }

    public void atualizarProblemaExistente(long idProblema, ProblemasExistentes problema) {
        try {
            String sql = "UPDATE tb_qfx_problemas_existentes SET nome_problema = ?, descricao_problema = ?, custo_mao_de_obra_problema = ?, qtd_peca = ?, id_peca = ? WHERE id_problema = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, problema.getNomeProblema());
            pstmt.setString(2, problema.getDescricaoProblema());
            pstmt.setDouble(3, problema.getCustoMaoDeObraProblema());
            pstmt.setInt(4, problema.getQtdPeca());
            pstmt.setLong(5, problema.getIdPeca());
            pstmt.setLong(6, idProblema);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProblemasExistentes> listarProblemasExistentes() {
        ArrayList<ProblemasExistentes> problemas = new ArrayList<>();
        String sql = "SELECT * FROM tb_qfx_problemas_existentes";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String nomeProblema = rs.getString("nome_problema");
                String descricaoProblema = rs.getString("descricao_problema");
                double custo = rs.getDouble("custo_mao_de_obra_problema");
                int qtdPeca = rs.getInt("qtd_peca");
                long idPeca = rs.getLong("id_peca");


                ProblemasExistentes problema = new ProblemasExistentes(nomeProblema, descricaoProblema, custo, qtdPeca, idPeca);
                problema.setIdProblemas(rs.getLong("id_problema"));
                problemas.add(problema);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problemas;
    }

    public void deletarProblemaExistente(long idProblema) {
        try {
            String sql = "DELETE FROM tb_qfx_problemas_existentes WHERE id_problema = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, idProblema);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProblemasExistentes buscarProblemasExistentesPorId(long problemasExistentesId) {
        ProblemasExistentes problema = null;
        String sql = "SELECT * FROM tb_qfx_problemas_existentes WHERE id_problema = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, problemasExistentesId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nomeProblema = rs.getString("nome_problema");
                    String descricaoProblema = rs.getString("descricao_problema");
                    double custoMaoDeObraProblema = rs.getDouble("custo_mao_de_obra_problema");
                    int qtdPeca = rs.getInt("qtd_peca");
                    long idPeca = rs.getLong("id_peca");


                    problema = new ProblemasExistentes(nomeProblema, descricaoProblema, custoMaoDeObraProblema, qtdPeca, idPeca);
                    problema.setIdProblemas(problemasExistentesId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problema;
    }

    public void fecharConexao(){
        try{
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
