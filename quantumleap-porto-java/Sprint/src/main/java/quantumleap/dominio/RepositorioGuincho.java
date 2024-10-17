package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioGuincho {
    public void adicionaGuincho(Guincho guincho);
    public Guincho buscarGuinchoPorId(long guinchoId);
    public void atualizarGuincho(long idGuincho, Guincho guincho);
    public ArrayList<Guincho> listarGuincho();
    public void deletarGuincho(long guinchoId);
    public void fecharConexao();
}
