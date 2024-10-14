package quantumleap.service;


import quantumleap.dominio.Oficina;
import quantumleap.dominio.RepositorioOficina;

import java.util.ArrayList;

public class OficinaService {

    private RepositorioOficina repositorioOficina;

    public OficinaService(RepositorioOficina repositorioOficina){
        this.repositorioOficina = repositorioOficina;
    }

    public void adicionar(Oficina oficina){
        repositorioOficina.adicionarOficina(oficina);
        repositorioOficina.fecharConexao();
    }

    public Oficina buscarOficinaPorId(Long id){
        Oficina oficina = repositorioOficina.buscarOficinaPorId(id);
        return oficina;
    }

    public ArrayList<Oficina> listarTodasOficinas(){
        ArrayList<Oficina> oficinas =  repositorioOficina.listarOficinas();
        repositorioOficina.fecharConexao();
        return oficinas;
    }

    public void atualizarOficina(Long id, Oficina oficina){
        repositorioOficina.atualizarOficina(id, oficina);
    }

    public void excluirOficina(Long id){
        repositorioOficina.excluirOficina(id);
    }
}
