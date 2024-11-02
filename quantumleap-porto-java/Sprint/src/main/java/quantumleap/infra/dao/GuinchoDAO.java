package quantumleap.infra.dao;

import quantumleap.dominio.Guincho;
import quantumleap.dominio.RepositorioGuincho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuinchoDAO implements RepositorioGuincho {

    private Connection conexao;

    public GuinchoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void adicionaGuincho(Guincho guincho) {
        String sqlInsert = "INSERT INTO tb_qfx_guincho (placa_guincho, preco_guincho, carga_maxima) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sqlInsert, new String[] {"id_guincho"})) {
            pstmt.setString(1, guincho.getPlaca());
            pstmt.setDouble(2, guincho.getPreco());
            pstmt.setDouble(3, guincho.getCargaMaxima());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    guincho.setIdGuincho(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao obter o ID gerado.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Guincho buscarGuinchoPorId(long guinchoId) {
        Guincho guincho = null;
        String sql = "SELECT placa_guincho, preco_guincho, carga_maxima FROM tb_qfx_guincho WHERE id_guincho = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, guinchoId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String placa = rs.getString("placa_guincho");
                    double preco = rs.getDouble("preco_guincho");
                    double cargaMaxima = rs.getDouble("carga_maxima");

                    guincho = new Guincho(placa, preco, cargaMaxima);
                    guincho.setIdGuincho(guinchoId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return guincho;
    }

    public void atualizarGuincho(long idGuincho, Guincho guincho) {
        String sqlUpdate = "UPDATE tb_qfx_guincho SET placa_guincho = ?, preco_guincho = ?, carga_maxima = ? WHERE id_guincho = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, guincho.getPlaca());
            pstmt.setDouble(2, guincho.getPreco());
            pstmt.setDouble(3, guincho.getCargaMaxima());
            pstmt.setLong(4, idGuincho);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Guincho> listarGuincho() {
        ArrayList<Guincho> guinchos = new ArrayList<>();
        String sql = "SELECT * FROM tb_qfx_guincho";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Guincho guincho = new Guincho();
                guincho.setIdGuincho(rs.getLong("id_guincho"));
                guincho.setPlaca(rs.getString("placa_guincho"));
                guincho.setPreco(rs.getDouble("preco_guincho"));
                guincho.setCargaMaxima(rs.getDouble("carga_maxima"));
                guinchos.add(guincho);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return guinchos;
    }

    public void deletarGuincho(long guinchoId) {
        String sqlDelete = "DELETE FROM tb_qfx_guincho WHERE id_guincho = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sqlDelete)) {
            pstmt.setLong(1, guinchoId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void fecharConexao(){
        try{
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
