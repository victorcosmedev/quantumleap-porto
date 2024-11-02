package quantumleap.service;

import quantumleap.dominio.ProblemasExistentes;
import quantumleap.dominio.RepositorioProblemasExistentes;

import java.util.ArrayList;

public class ProblemasExistentesService {
    private RepositorioProblemasExistentes repositorioProblemasExistentes;

    public ProblemasExistentesService(RepositorioProblemasExistentes repositorioProblemasExistentes) {
        this.repositorioProblemasExistentes = repositorioProblemasExistentes;
    }

    public void adicionarProblema(ProblemasExistentes problemasExistentes){
        repositorioProblemasExistentes.adicionarProblemaExistente(problemasExistentes);
        repositorioProblemasExistentes.fecharConexao();
    }

    public ProblemasExistentes buscarProblemaPorID(long id){
        ProblemasExistentes problemasExistentes = repositorioProblemasExistentes.buscarProblemaPorId(id);
        repositorioProblemasExistentes.fecharConexao();
        return problemasExistentes;
    }

    public void atualizarProblema(long id, ProblemasExistentes problemasExistentes){
        repositorioProblemasExistentes.atualizarProblemaExistente(id, problemasExistentes);
        repositorioProblemasExistentes.fecharConexao();
    }

    public ArrayList<ProblemasExistentes> retornaProblemas(){
        ArrayList<ProblemasExistentes> problemas = repositorioProblemasExistentes.listarProblemasExistentes();
        repositorioProblemasExistentes.fecharConexao();
        return problemas;
    }

    public void deletarProblemas(long id){
        repositorioProblemasExistentes.deletarProblemaExistente(id);
        repositorioProblemasExistentes.fecharConexao();
    }

}
