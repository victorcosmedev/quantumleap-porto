package dominio;

import org.junit.jupiter.api.Test;
import quantumleap.infra.ClienteDAO;
import quantumleap.dominio.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteDAOTest {

    @Test
    public void testAdicionaCliente() {
        Cliente cliente = new Cliente("ClienteTest1", "ClienteTest1@gmail.com", "11111111111", "senhaclientetest", true, "São Paulo");
        Cliente cliente2 = new Cliente("ClienteTest2", "ClienteTest2@gmail.com", "11111111111", "senhaclientetest", true, "São Paulo");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.adicionarCliente(cliente);
        clienteDAO.adicionarCliente(cliente2);
    }

    @Test
    public void buscandoClienteP1orId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        long idCliente = sc.nextLong();
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarClientePorId(idCliente);

        if (cliente == null) {
            System.out.println(".");
        } else {
            System.out.println("ID:" + cliente.getIdCliente());
            System.out.println("Nome:" + cliente.getNomeCliente());
            System.out.println("Email:" + cliente.getEmailCliente());
            System.out.println("Telefone" + cliente.getTelefoneCliente());
            System.out.println("Senha:" + cliente.getSenhaCliente());
            System.out.println("Cliente Porto:" + cliente.getClientePorto());
            System.out.println("Localização:" + cliente.getLocalizacaoCliente());
        }
    }

    @Test
    public void testListarClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.listarClientes();

        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getIdCliente());
            System.out.println("Nome: " + cliente.getNomeCliente());
            System.out.println("Email: " + cliente.getEmailCliente());
            System.out.println("Telefone: " + cliente.getTelefoneCliente());
            System.out.println("Senha: " + cliente.getSenhaCliente());
            System.out.println("Cliente Porto: " + (cliente.getClientePorto() ? "Sim" : "Não"));
            System.out.println("Localização: " + cliente.getLocalizacaoCliente());
            System.out.println("---------------------------");
        }


    }

    @Test
    public void atualizarCliente() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("ClienteAtualizado", "ClienteAtualizado@gmail.com", "123", "senha", false, "rio");

        long idCliente = 1L;

        if(clienteDAO.buscarClientePorId(idCliente) == null){
            System.out.println("ID Cliente não encontrado.");
        }else {
            System.out.println("Cliente atualizado com sucesso! .");
            clienteDAO.atualizarCliente(idCliente, cliente);
        }
    }

    @Test
    public void deletarCliente() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Long idCliente = 2L;
        clienteDAO.removerCliente(idCliente);
    }
}
