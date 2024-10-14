package dominio;

import org.junit.jupiter.api.Test;
import quantumleap.infra.PecaDAO;
import quantumleap.dominio.Peca;

import java.util.ArrayList;

public class PecaDAOTest {

    @Test
    void adicionaPeca(){
        Peca peca = new Peca("Peça", 100, "teste", "teste");
        Peca peca2 = new Peca("Peça2", 100, "teste", "teste");
        PecaDAO pecaDAO = new PecaDAO();
        pecaDAO.adicionaPeca(peca2);
        pecaDAO.adicionaPeca(peca);
    }

    @Test
    void buscandoPecaPeloId(){
        PecaDAO pecaDAO = new PecaDAO();
        Peca peca = pecaDAO.buscarPecaPorId(1L);

        if(peca == null){
            System.out.println("Peça não encontrada");
        }else{
            System.out.println("Peca Encontrada!");
            System.out.println("Nome: " + peca.getNomePeca());
            System.out.println("Preço: " + peca.getPrecoPeca());
            System.out.println("Marca: " + peca.getMarcaPeca());
            System.out.println("Modelo: " + peca.getModeloPeca());
        }

    }

    @Test
    void atualizaPeca(){
        PecaDAO pecaDAO = new PecaDAO();
        Peca peca = new Peca("PecaAtualizada", 150.00, "Nova Marca", "Novo Modelo");
        long idPeca = 1L;

        if (pecaDAO.buscarPecaPorId(idPeca) == null){
            System.out.println("ID Peça não encontrada!");
        } else {
            System.out.println("Peca Atualizada!");
            pecaDAO.atualizarPeca(idPeca, peca);
        }

    }


    @Test
    void listandoPecas(){
        PecaDAO pecaDAO = new PecaDAO();
        ArrayList<Peca> pecas = pecaDAO.listarPeca();

        if(pecas == null){
            System.out.println("Não existe peças.");
        }else {
            for (Peca peca: pecas){
                System.out.println("ID: " + peca.getIdPeca());
                System.out.println("Nome Peça: " + peca.getNomePeca());
                System.out.println("Preço: " + peca.getPrecoPeca());
                System.out.println("Modelo: "+ peca.getModeloPeca());
                System.out.println("Marca: "+ peca.getMarcaPeca());
                System.out.println("------------------------------");
            }
        }

    }

    @Test
    void removendoPecaPeloId(){
        PecaDAO pecaDAO = new PecaDAO();
        long idPeca = 2L;
        Peca peca = pecaDAO.buscarPecaPorId(idPeca);
        if (peca == null){
            System.out.println("ID peça não existe.");
        } else {
            System.out.println("Peça removida.");
            pecaDAO.removerPeca(idPeca);
        }

    }



}
