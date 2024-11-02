package dominio;

import org.junit.jupiter.api.Test;
import quantumleap.infra.dao.OficinaDAO;
import quantumleap.dominio.Oficina;

import java.util.ArrayList;

public class OficinaDAOTest {

    @Test
    public void adicionarOficina(){
        Oficina oficina1 = new Oficina("Oficina1", "Rua Teste","123", "email@teste.com");
        Oficina oficina2 = new Oficina("Oficina2", "Rua Teste","123", "email@teste.com");

        OficinaDAO oficinaDAO = new OficinaDAO();
        oficinaDAO.adicionarOficina(oficina1);
        oficinaDAO.adicionarOficina(oficina2);
    }

        @Test
        void buscandoOficinasPorID() {
            OficinaDAO oficinaDAO = new OficinaDAO();
            Oficina oficina = oficinaDAO.buscarOficinaPorId(1L);

            if (oficina != null) {
                System.out.println("Oficina encontrada:");
                System.out.println("ID: " + oficina.getIdOficina());
                System.out.println("Nome: " + oficina.getNomeOficina());
                System.out.println("Localização: " + oficina.getLocalizacaoOficina());
                System.out.println("Telefone: " + oficina.getTelefoneOficina());
                System.out.println("Email: " + oficina.getEmailOficina());
            } else {
                System.out.println("Nenhuma oficina encontrada com o ID fornecido.");
            }
        }


    @Test
    public void atualizandoOficina(){
        Oficina oficina1 = new Oficina("OficinaAtualizada", "Rua OficinaAtualizada","123", "email@teste.com");
        OficinaDAO oficinaDAO = new OficinaDAO();
        long idOficina = 1L;
        Oficina oficina = oficinaDAO.buscarOficinaPorId(idOficina);
        if (oficina == null) {
            System.out.println("Oficina não encontrada.");
        }else {
            System.out.println("Oficina Atualizada.");
            oficinaDAO.atualizarOficina(idOficina, oficina1);
        }
    }






    @Test
    public void listarOficinas() {
        OficinaDAO dao = new OficinaDAO();
        ArrayList<Oficina> oficinas = (ArrayList<Oficina>) dao.listarOficinas();

        for (Oficina oficina : oficinas) {
            System.out.println("ID: " +oficina.getIdOficina());
            System.out.println("Nome: " + oficina.getNomeOficina());
            System.out.println("Localização: " + oficina.getLocalizacaoOficina());
            System.out.println("Telefone: " + oficina.getTelefoneOficina());
            System.out.println("Email: " + oficina.getEmailOficina());
            System.out.println("--------------");
        }
    }

    @Test
    public void excluirOficina(){
        OficinaDAO dao = new OficinaDAO();
        long idOficina = 2L;
        Oficina oficina = dao.buscarOficinaPorId(idOficina);
        if (oficina == null) {
            System.out.println("Oficina não encontrada.");
        }else {
            System.out.println("Oficina excluida com sucesso.");
            dao.excluirOficina(2L);
        }
    }





}
