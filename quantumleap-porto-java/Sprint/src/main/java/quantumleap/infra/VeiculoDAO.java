package quantumleap.infra;

import quantumleap.dominio.Cliente;
import quantumleap.dominio.RepositorioVeiculo;
import quantumleap.dominio.Veiculo;

import java.sql.*;
import java.util.ArrayList;

public class VeiculoDAO implements RepositorioVeiculo {

    private Connection conexao;

    public VeiculoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }


    public void adicionarVeiculo(Cliente cliente, Veiculo veiculo) {
        String sql = "INSERT INTO tb_qfx_veiculo (id_cliente, montadora_veiculo, modelo_veiculo, ano_veiculo, quantidade_quilometros, placa_veiculo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql, new String[] {"id_veiculo"})) {

            pstmt.setLong(1, cliente.getIdCliente());
            pstmt.setString(2, veiculo.getMontadoraVeiculo());
            pstmt.setString(3, veiculo.getModeloVeiculo());
            pstmt.setDate(4, new Date(veiculo.getAnoVeiculo().getTime()));
            pstmt.setDouble(5, veiculo.getQuantidadeQuilometros());
            pstmt.setString(6, veiculo.getPlacaVeiculo());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    veiculo.setIdVeiculo(generatedKeys.getLong(1));
                } else {
                    throw new SQLException();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Veiculo buscarVeiculoPorId(long veiculoId) {
        Veiculo veiculo = null;
        String sql = "SELECT * FROM tb_qfx_veiculo WHERE id_veiculo = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, veiculoId);
            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                    veiculo = new Veiculo(
                            rs.getString("montadora_veiculo"),
                            rs.getString("modelo_veiculo"),
                            rs.getDate("ano_veiculo"),
                            rs.getDouble("quantidade_quilometros"),
                            rs.getString("placa_veiculo")
                    );
                    veiculo.setIdVeiculo(rs.getLong("id_veiculo"));
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculo;
    }


    public void atualizarVeiculo(long idVeiculo, Veiculo veiculo) {
        String sql = "UPDATE tb_qfx_veiculo SET montadora_veiculo = ?, modelo_veiculo = ?, ano_veiculo = ?, quantidade_quilometros = ?, placa_veiculo = ? WHERE id_veiculo = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, veiculo.getMontadoraVeiculo());
            pstmt.setString(2, veiculo.getModeloVeiculo());
            pstmt.setDate(3, new Date(veiculo.getAnoVeiculo().getTime()));
            pstmt.setDouble(4, veiculo.getQuantidadeQuilometros());
            pstmt.setString(5, veiculo.getPlacaVeiculo());
            pstmt.setLong(6, idVeiculo);

            pstmt.executeUpdate();
            System.out.println("Veículo atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deletarVeiculo(long veiculoId) {
        String sql = "DELETE FROM tb_qfx_veiculo WHERE id_veiculo = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, veiculoId);
            pstmt.executeUpdate();
            System.out.println("Veículo deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Veiculo> listarVeiculos() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT v.id_veiculo, v.montadora_veiculo, v.modelo_veiculo, v.ano_veiculo, v.quantidade_quilometros, v.placa_veiculo, c.nome_cliente " +
                "FROM tb_qfx_veiculo v " +
                "JOIN tb_qfx_cliente c ON v.id_cliente = c.id_cliente";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getString("montadora_veiculo"),
                        rs.getString("modelo_veiculo"),
                        rs.getDate("ano_veiculo"),
                        rs.getDouble("quantidade_quilometros"),
                        rs.getString("placa_veiculo")
                );
                veiculo.setIdVeiculo(rs.getLong("id_veiculo"));
                veiculo.setNomeCliente(rs.getString("nome_cliente"));

                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }


    public void fecharConexao(){
        try{
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
