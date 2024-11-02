package quantumleap.service;

import quantumleap.dominio.Cliente;
import quantumleap.dominio.RepositorioCliente;

import java.util.ArrayList;

public class ClienteService {

    private RepositorioCliente repositorioCliente;

    public ClienteService(RepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public void adicionar(Cliente cliente){
        repositorioCliente.adicionarCliente(cliente);
        repositorioCliente.fecharConexao();
    }

    public ArrayList<Cliente> listarTodosClientes(){
        ArrayList<Cliente> listaClientes = repositorioCliente.listarClientes();
        repositorioCliente.fecharConexao();
        return listaClientes;
    }

    public Cliente buscarClientePorId(Long id){
        Cliente cliente =  repositorioCliente.buscarClientePorId(id);
        repositorioCliente.fecharConexao();
        return cliente;
    }

    public void atualizarCliente(Long id, Cliente cliente){
        repositorioCliente.atualizarCliente(id, cliente);
        repositorioCliente.fecharConexao();
    }

    public void removerCliente(Long id){
        repositorioCliente.removerCliente(id);
        repositorioCliente.fecharConexao();
    }



    public Cliente authenticateAndRetrieve(String email, String senha) throws Exception {
        return repositorioCliente.findByEmailAndPassword(email, senha);
    }
}
