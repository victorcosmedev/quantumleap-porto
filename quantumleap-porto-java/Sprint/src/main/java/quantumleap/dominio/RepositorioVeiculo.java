package quantumleap.dominio;

import java.util.ArrayList;
import java.util.List;

public interface RepositorioVeiculo {
    void adicionarVeiculo(Veiculo veiculo);
    Veiculo buscarVeiculoPorId(long veiculoId);
    void atualizarVeiculo(long idVeiculo, Veiculo veiculo);
    void deletarVeiculo(long veiculoId);
    ArrayList<Veiculo> listarVeiculos();
    ArrayList<Veiculo> buscarVeiculosPorIdCliente(long clienteId);
    void fecharConexao();

}
