package dominio;

import org.junit.jupiter.api.Test;
import quantumleap.infra.PecaDAO;
import quantumleap.infra.ProblemasExistentesDAO;
import quantumleap.dominio.Peca;
import quantumleap.dominio.ProblemasExistentes;

import java.util.ArrayList;

public class ProblemasExistentesDAOTest {


    @Test
    void adicionandoProblemasComPecas() {
        PecaDAO pecaDAO = new PecaDAO();
        ProblemasExistentesDAO problemasDAO = new ProblemasExistentesDAO();

        Long idPecaExistente = 1L;
        Peca pecaExistente = pecaDAO.buscarPecaPorId(idPecaExistente);
        ProblemasExistentes problema = new ProblemasExistentes("Teste2", "Teste", 100, 2, pecaExistente);
        ProblemasExistentes problema2 = new ProblemasExistentes("Teste2", "Teste", 100, 2, pecaExistente);
        problemasDAO.adicionarProblemaExistente(problema);
        problemasDAO.adicionarProblemaExistente(problema2);


    }


    @Test
    public void buscandoProblemasPorId() {
        ProblemasExistentesDAO problemasDAO = new ProblemasExistentesDAO();
        Long idProblema = 1L;
        ProblemasExistentes problema = problemasDAO.buscarProblemaPorId(idProblema);

        if (problema != null) {
            System.out.println("Problema encontrado:");
            System.out.println("ID: " + problema.getIdProblemas());
            System.out.println("Nome: " + problema.getNomeProblema());
            System.out.println("Descrição: " + problema.getDescricaoProblema());
            System.out.println("Custo de Mão de Obra: " + problema.getCustoMaoDeObraProblema());
            System.out.println("Quantidade de Peças: " + problema.getQtdPeca());
        } else {
            System.out.println("Nenhum problema encontrado com o ID: " + idProblema);
        }
    }

    @Test
    public void atualizandoProblemas() {
        ProblemasExistentesDAO problemasDAO = new ProblemasExistentesDAO();
        PecaDAO pecaDAO = new PecaDAO();
        Long idProblema = 1L;
        Long idPecaExistente = 1L;
        Peca pecaExistente = pecaDAO.buscarPecaPorId(idPecaExistente);
        ProblemasExistentes problema = new ProblemasExistentes("ProblemaAtualizado", "ProblemaAtualizado", 100, 2, pecaExistente);
        problemasDAO.atualizarProblemaExistente(idProblema, problema);
    }

    @Test
    public void listandoProblemas(){
        ProblemasExistentesDAO problemasDAO = new ProblemasExistentesDAO();
        ArrayList<ProblemasExistentes> problemasExistentes = problemasDAO.listarProblemasExistentes();
        for (ProblemasExistentes problema : problemasExistentes) {
            System.out.println("ID: " + problema.getIdProblemas());
            System.out.println("Nome: " + problema.getNomeProblema());
            System.out.println("Descricao: " + problema.getDescricaoProblema());
            System.out.println("Custo Mão de Obra: " + problema.getCustoMaoDeObraProblema());
            System.out.println("Quantidade de Peças: " + problema.getQtdPeca());
            System.out.println("Peca: " + problema.getPeca().getNomePeca());
            System.out.println("---------------------");
        }
    }

    @Test
    public void deletandoProblema(){
        ProblemasExistentesDAO problemasExistentesDAO = new ProblemasExistentesDAO();
        long idProblema = 2L;
        ProblemasExistentes problema = problemasExistentesDAO.buscarProblemaPorId(idProblema);
        if (problema == null) {
            System.out.println("Problema não encontrado.");
        }else {
            System.out.println("Problema deletado com sucesso.");
            problemasExistentesDAO.deletarProblemaExistente(idProblema);
        }

    }


}
