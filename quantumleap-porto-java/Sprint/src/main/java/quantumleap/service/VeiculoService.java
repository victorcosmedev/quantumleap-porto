package quantumleap.service;

import quantumleap.dominio.Cliente;
import quantumleap.dominio.RepositorioVeiculo;
import quantumleap.dominio.Veiculo;

public class VeiculoService {

    private RepositorioVeiculo repositorioVeiculo;

    public VeiculoService(RepositorioVeiculo repositorioVeiculo){
        this.repositorioVeiculo = repositorioVeiculo;
    }

    public void adicionar(Cliente cliente, Veiculo veiculo){
        repositorioVeiculo.adicionarVeiculo(cliente, veiculo);
        repositorioVeiculo.fecharConexao();
    }













}
