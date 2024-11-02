package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioGuincho {
    void adicionaGuincho(Guincho guincho);
    Guincho buscarGuinchoPorId(long guinchoId);
    void atualizarGuincho(long idGuincho, Guincho guincho);
    ArrayList<Guincho> listarGuincho();
    void deletarGuincho(long guinchoId);
    void fecharConexao();
}
