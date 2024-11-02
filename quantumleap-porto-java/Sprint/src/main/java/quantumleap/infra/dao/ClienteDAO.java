package quantumleap.infra.dao;

import quantumleap.dominio.Cliente;
import quantumleap.dominio.RepositorioCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO implements RepositorioCliente {

    private Connection conexao;

    public ClienteDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }



    public void adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO tb_qfx_cliente (nome_cliente, email_cliente, telefone_cliente, senha_cliente, cliente_porto, localizacao_cliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"id_cliente"})) {
            pstmt.setString(1, cliente.getNomeCliente());
            pstmt.setString(2, cliente.getEmailCliente());
            pstmt.setString(3, cliente.getTelefoneCliente());
            pstmt.setString(4, cliente.getSenhaCliente());
            pstmt.setBoolean(5, cliente.getClientePorto());
            pstmt.setString(6, cliente.getLocalizacaoCliente());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cliente.setIdCliente(generatedKeys.getLong(1));
                } else {
                    throw new SQLException();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente findByEmailAndPassword(String email, String senha) throws SQLException {
        Cliente cliente = null;
        String sql = "SELECT * FROM tb_qfx_cliente WHERE email_cliente = ? AND senha_cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getLong("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEmailCliente(rs.getString("email_cliente"));
                cliente.setTelefoneCliente(rs.getString("telefone_cliente"));
                cliente.setSenhaCliente(rs.getString("senha_cliente"));
                cliente.setClientePorto(rs.getInt("cliente_porto") == 1);
                cliente.setLocalizacaoCliente(rs.getString("localizacao_cliente"));
            }
        }
        return cliente;
    }


    public Cliente buscarClientePorId(Long id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM tb_qfx_cliente WHERE id_cliente = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setIdCliente(rs.getLong("id_cliente"));
                    cliente.setNomeCliente(rs.getString("nome_cliente"));
                    cliente.setEmailCliente(rs.getString("email_cliente"));
                    cliente.setTelefoneCliente(rs.getString("telefone_cliente"));
                    cliente.setSenhaCliente(rs.getString("senha_cliente"));
                    cliente.setClientePorto(rs.getInt("cliente_porto") == 1);
                    cliente.setLocalizacaoCliente(rs.getString("localizacao_cliente"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM tb_qfx_cliente";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getLong("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEmailCliente(rs.getString("email_cliente"));
                cliente.setTelefoneCliente(rs.getString("telefone_cliente"));
                cliente.setSenhaCliente(rs.getString("senha_cliente"));
                cliente.setClientePorto(rs.getInt("cliente_porto") == 1);
                cliente.setLocalizacaoCliente(rs.getString("localizacao_cliente"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void atualizarCliente(long idCliente, Cliente cliente) {
        String sql = "UPDATE tb_qfx_cliente SET nome_cliente = ?, email_cliente = ?, telefone_cliente = ?, senha_cliente = ?, cliente_porto = ?, localizacao_cliente = ? WHERE id_cliente = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNomeCliente());
            pstmt.setString(2, cliente.getEmailCliente());
            pstmt.setString(3, cliente.getTelefoneCliente());
            pstmt.setString(4, cliente.getSenhaCliente());
            pstmt.setBoolean(5, cliente.getClientePorto());
            pstmt.setString(6, cliente.getLocalizacaoCliente());
            pstmt.setLong(7, idCliente);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerCliente(Long idCliente) {
        String sqlDeleteCliente = "DELETE FROM tb_qfx_cliente WHERE id_cliente = ?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sqlDeleteCliente)) {
            pstmt.setLong(1, idCliente);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
