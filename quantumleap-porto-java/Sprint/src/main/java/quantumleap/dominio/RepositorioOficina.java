package quantumleap.dominio;

import java.util.ArrayList;
import java.util.List;

public interface RepositorioOficina {

    public void adicionarOficina(Oficina oficina);
    public Oficina buscarOficinaPorId(long idOficina);
    public ArrayList<Oficina> listarOficinas();
    public void atualizarOficina(Long idOficina, Oficina oficina);
    public void excluirOficina(Long idOficina);
    public void fecharConexao();

}
