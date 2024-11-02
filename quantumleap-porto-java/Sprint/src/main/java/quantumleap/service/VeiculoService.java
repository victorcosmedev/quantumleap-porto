package quantumleap.service;

import quantumleap.dominio.Cliente;
import quantumleap.dominio.RepositorioVeiculo;
import quantumleap.dominio.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoService {

    private RepositorioVeiculo repositorioVeiculo;

    public VeiculoService(RepositorioVeiculo repositorioVeiculo){
        this.repositorioVeiculo = repositorioVeiculo;
    }

    public void adicionar(Veiculo veiculo){
        repositorioVeiculo.adicionarVeiculo(veiculo);
        repositorioVeiculo.fecharConexao();
    }

    public Veiculo retornaVeiculoPorId(long id){
        Veiculo veiculo = repositorioVeiculo.buscarVeiculoPorId(id);
        repositorioVeiculo.fecharConexao();
        return veiculo;
    }

    public void atualizarVeiculo(long id, Veiculo veiculo){
        repositorioVeiculo.atualizarVeiculo(id, veiculo);
        repositorioVeiculo.fecharConexao();
    }

    public void deletarVeiculo(long id){
        repositorioVeiculo.deletarVeiculo(id);
        repositorioVeiculo.fecharConexao();
    }

    public ArrayList<Veiculo> listarTodosVeiculos(){
        ArrayList<Veiculo> veiculos = repositorioVeiculo.listarVeiculos();
        repositorioVeiculo.fecharConexao();
        return veiculos;
    }

    public ArrayList<Veiculo> buscarVeiculosPorIdCliente(long clienteId){
        ArrayList<Veiculo> veiculosPorCliente = repositorioVeiculo.buscarVeiculosPorIdCliente(clienteId);
        repositorioVeiculo.fecharConexao();
        return veiculosPorCliente;
    }













}
