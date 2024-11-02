package quantumleap.service;

import quantumleap.dominio.Guincho;
import quantumleap.dominio.RepositorioGuincho;

import java.util.ArrayList;

public class GuinchoService {

    private RepositorioGuincho repositorioGuincho;

    public GuinchoService(RepositorioGuincho repositorioGuincho){
        this.repositorioGuincho = repositorioGuincho;
    }

    public void adicionar(Guincho guincho){
        repositorioGuincho.adicionaGuincho(guincho);
        repositorioGuincho.fecharConexao();
    }

    public Guincho buscarGuinchoPorId(long guinchoId){
        Guincho guincho = repositorioGuincho.buscarGuinchoPorId(guinchoId);
        repositorioGuincho.fecharConexao();
        return guincho;
    }

    public void atualizarGuincho(long idGuincho, Guincho guincho){
        repositorioGuincho.atualizarGuincho(idGuincho, guincho);
        repositorioGuincho.fecharConexao();
    }

    public ArrayList<Guincho> listarGuincho(){
        ArrayList<Guincho> guinchos = repositorioGuincho.listarGuincho();
        repositorioGuincho.fecharConexao();
        return guinchos;
    }

    public void deletarGuincho(long guinchoId){
        repositorioGuincho.deletarGuincho(guinchoId);
        repositorioGuincho.fecharConexao();
    }
}
