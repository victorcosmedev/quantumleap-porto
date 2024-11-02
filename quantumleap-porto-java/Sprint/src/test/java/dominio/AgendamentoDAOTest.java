package dominio;

import org.junit.jupiter.api.Test;
import quantumleap.dominio.*;
import quantumleap.infra.dao.AgendamentoDAO;
import quantumleap.infra.dao.DiagnosticoDAO;
import quantumleap.infra.dao.OficinaDAO;

import java.text.ParseException;
import java.util.ArrayList;

public class AgendamentoDAOTest {

    @Test
    public void adicionandoAgendamentoDAO() throws ParseException {

        //Agendamento 1:


        Agendamento agendamento = new Agendamento(1L, "12/11/11", "12:00", 1L);
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

        agendamentoDAO.adicionarAgendamento(agendamento);


        //Agendamento 2:

        Agendamento agendamento2 = new Agendamento(1L, "12/11/11", "12:30", 1L);
        agendamentoDAO.adicionarAgendamento(agendamento2);
    }

    @Test
    public void buscandoAgendamentosPorId() {
        AgendamentoDAO dao = new AgendamentoDAO();
        Agendamento agendamento = dao.buscarAgendamentoPorId(1L);

        OficinaDAO oficinaDAO = new OficinaDAO();
        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();

        if (agendamento != null) {
            System.out.println("Data: " + agendamento.getData());
            System.out.println("Hora: " + agendamento.getHora());
            System.out.println("Localização Oficina: " + oficinaDAO.buscarOficinaPorId(agendamento.getIdOficina()));
            System.out.println("Descrição: " + diagnosticoDAO.buscarDiagnosticoPorId(agendamento.getIdDiagnostico()));
        } else {
            System.out.println("Agendamento não encontrado.");
        }
    }

    @Test
    public void atualizarAgendamento() throws ParseException {

        Agendamento agendamentoNovo = new Agendamento(1L, "13/11/11", "18:00", 1L);
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

        long idAgen = 1L;
        Agendamento agend = agendamentoDAO.buscarAgendamentoPorId(idAgen);
        if (agend == null) {
            System.out.println("Agendamento não encontrado!");
        }else {
            System.out.println("Agendamento encontrado!");
            agendamentoDAO.atualizarAgendamento(idAgen, agendamentoNovo);
        }


    }


    @Test
    public void listarAgendamentos() {
        AgendamentoDAO dao = new AgendamentoDAO();

        ArrayList<Agendamento> agendamentos = dao.listarAgendamentos();

        for (Agendamento agendamento : agendamentos) {
            System.out.println("ID Agendamento: " + agendamento.getIdAgendamento());
            System.out.println("ID Diagnostico: " + agendamento.getIdDiagnostico());
            System.out.println("ID Oficina: " + agendamento.getIdOficina());
            System.out.println("Data: " + agendamento.getData());
            System.out.println("Hora: " + agendamento.getHora());
            System.out.println("Oficina: " + agendamento.getIdOficina());
            System.out.println("Descrição: " + agendamento.getIdDiagnostico());
            System.out.println("------------");
        }
    }

    @Test
    public void deletarAgendamento(){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.deletarAgendamento(2L);
    }





}
