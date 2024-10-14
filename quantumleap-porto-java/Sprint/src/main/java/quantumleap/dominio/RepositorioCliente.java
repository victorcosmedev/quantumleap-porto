package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioCliente {


    public void adicionarCliente(Cliente cliente);
    public ArrayList<Cliente> listarClientes();
    public Cliente buscarClientePorId(Long id);
    public void atualizarCliente(long idCliente, Cliente cliente);
    public void removerCliente(Long idCliente);
    public void fecharConexao();
}
