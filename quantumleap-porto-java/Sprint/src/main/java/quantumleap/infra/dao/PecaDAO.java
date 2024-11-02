package quantumleap.infra.dao;

import quantumleap.dominio.Peca;
import quantumleap.dominio.RepositorioPeca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO implements RepositorioPeca {
    private Connection conexao;
    public PecaDAO() {this.conexao = new ConnectionFactory().getConnection();}


    public void adicionaPeca(Peca peca) {
        String sqlInsert = "INSERT INTO tb_qfx_peca (nome_peca, preco_peca, marca_peca, modelo_peca) VALUES (?, ?, ?, ?)";
        try (Connection conexao = new ConnectionFactory().getConnection();
             PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert)) {
            comandoDeInsercao.setString(1, peca.getNomePeca());
            comandoDeInsercao.setDouble(2, peca.getPrecoPeca());
            comandoDeInsercao.setString(3, peca.getMarcaPeca());
            comandoDeInsercao.setString(4, peca.getModeloPeca());
            comandoDeInsercao.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Peca buscarPecaPorId(Long idPeca) {
        Peca peca = null;
        String sql = "SELECT * FROM tb_qfx_peca WHERE id_peca = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, idPeca);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    peca = new Peca();
                    peca.setIdPeca(idPeca);
                    peca.setNomePeca(rs.getString("nome_peca"));
                    peca.setPrecoPeca(rs.getDouble("preco_peca"));
                    peca.setMarcaPeca(rs.getString("marca_peca"));
                    peca.setModeloPeca(rs.getString("modelo_peca"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return peca;
    }

    public void atualizarPeca(long idPeca, Peca peca) {
        String sqlUpdate = "UPDATE tb_qfx_peca SET nome_peca = ?, preco_peca = ?, marca_peca = ?, modelo_peca = ? WHERE id_peca = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
             PreparedStatement comandoDeAtualizacao = conexao.prepareStatement(sqlUpdate)) {
            comandoDeAtualizacao.setString(1, peca.getNomePeca());
            comandoDeAtualizacao.setDouble(2, peca.getPrecoPeca());
            comandoDeAtualizacao.setString(3, peca.getMarcaPeca());
            comandoDeAtualizacao.setString(4, peca.getModeloPeca());
            comandoDeAtualizacao.setLong(5, idPeca);
            comandoDeAtualizacao.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerPeca(Long idPeca) {
        String sqlDelete = "DELETE FROM tb_qfx_peca WHERE id_peca = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
             PreparedStatement comandoDeRemocao = conexao.prepareStatement(sqlDelete)) {
            comandoDeRemocao.setLong(1, idPeca);
            comandoDeRemocao.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Peca> listarPeca() {
        ArrayList<Peca> pecas = new ArrayList<>();
        String sql = "SELECT * FROM tb_qfx_peca";
        try (Connection conexao = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Peca peca = new Peca();
                peca.setIdPeca(rs.getLong("id_peca"));
                peca.setNomePeca(rs.getString("nome_peca"));
                peca.setPrecoPeca(rs.getDouble("preco_peca"));
                peca.setMarcaPeca(rs.getString("marca_peca"));
                peca.setModeloPeca(rs.getString("modelo_peca"));
                pecas.add(peca);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pecas;
    }

    public void fechar(){
        try{
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
