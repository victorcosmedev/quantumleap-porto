package quantumleap.dominio;

import java.util.ArrayList;
import java.util.List;

public interface RepositorioOficina {

    void adicionarOficina(Oficina oficina);
    Oficina buscarOficinaPorId(long idOficina);
    ArrayList<Oficina> listarOficinas();
    void atualizarOficina(Long idOficina, Oficina oficina);
    void excluirOficina(Long idOficina);
    void fecharConexao();

}
