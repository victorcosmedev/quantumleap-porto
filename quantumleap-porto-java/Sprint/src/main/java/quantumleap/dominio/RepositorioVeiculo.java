package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioVeiculo {
    public void adicionarVeiculo(Cliente cliente, Veiculo veiculo);
    public Veiculo buscarVeiculoPorId(long veiculoId);
    public void atualizarVeiculo(long idVeiculo, Veiculo veiculo);
    public void deletarVeiculo(long veiculoId);
    public ArrayList<Veiculo> listarVeiculos();
    public void fecharConexao();

}
