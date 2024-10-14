package dominio;

import org.junit.jupiter.api.Test;
import quantumleap.infra.*;
import quantumleap.dominio.*;

import java.text.ParseException;
import java.util.ArrayList;

public class AgendamentoDAOTest {

    @Test
    public void adicionandoAgendamentoDAO() throws ParseException {

        //Agendamento 1:
        OficinaDAO oficinaDAO = new OficinaDAO();
        Long idOficina = 1L;
        Oficina oficina = oficinaDAO.buscarOficinaPorId(idOficina);

        DiagnosticoDAO dao = new DiagnosticoDAO();

        long idCliente = 1L;
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        }

        long idVeiculo = 1L;
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo veiculo = veiculoDAO.buscarVeiculoPorId(idVeiculo);
        if (veiculo == null) {
            System.out.println("Veiculo não encontrado.");
        }

        long idGuincho = 1L;
        GuinchoDAO guinchoDAO = new GuinchoDAO();
        Guincho guincho = guinchoDAO.buscarGuinchoPorId(idGuincho);
        if (guincho == null){
            System.out.println("Guincho não encontrado.");
        }

        long idPeca = 1L;
        PecaDAO pecaDAO = new PecaDAO();
        Peca pecaExistente = pecaDAO.buscarPecaPorId(idPeca);
        if (pecaExistente == null) {
            System.out.println("Peca não encontrada.");
        }

        long idProblema = 1L;
        ProblemasExistentesDAO problemasExistentesDAO = new ProblemasExistentesDAO();
        ProblemasExistentes problemas = problemasExistentesDAO.buscarProblemaPorId(idProblema);
        if (problemas == null) {
            System.out.println("Problema não encontrado.");
        }

        Diagnostico diagnostico = new Diagnostico(cliente, veiculo, problemas, guincho );
        dao.adicionarDiagnostico(diagnostico);

        Agendamento agendamento = new Agendamento(diagnostico, "12/11/11", "12:00", oficina);
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

        agendamentoDAO.adicionarAgendamento(agendamento);


        //Agendamento 2:

        Agendamento agendamento2 = new Agendamento(diagnostico, "12/11/11", "12:30", oficina);
        agendamentoDAO.adicionarAgendamento(agendamento2);
    }

    @Test
    public void buscandoAgendamentosPorId() {
        AgendamentoDAO dao = new AgendamentoDAO();
        Agendamento agendamento = dao.buscarAgendamentoPorId(1L);

        if (agendamento != null) {
            System.out.println("Data: " + agendamento.getData());
            System.out.println("Hora: " + agendamento.getHora());
            System.out.println("Localização Oficina: " + agendamento.getOficina().getLocalizacaoOficina());
            System.out.println("Descrição: " + agendamento.getDiagnostico().getDescricao());
        } else {
            System.out.println("Agendamento não encontrado.");
        }
    }

    @Test
    public void atualizarAgendamento() throws ParseException {
        OficinaDAO oficinaDAO = new OficinaDAO();
        Long idOficina = 1L;
        Oficina oficina = oficinaDAO.buscarOficinaPorId(idOficina);

        DiagnosticoDAO dao = new DiagnosticoDAO();

        long idCliente = 1L;
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        }

        long idVeiculo = 1L;
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo veiculo = veiculoDAO.buscarVeiculoPorId(idVeiculo);
        if (veiculo == null) {
            System.out.println("Veiculo não encontrado.");
        }

        long idGuincho = 1L;
        GuinchoDAO guinchoDAO = new GuinchoDAO();
        Guincho guincho = guinchoDAO.buscarGuinchoPorId(idGuincho);
        if (guincho == null){
            System.out.println("Guincho não encontrado.");
        }

        long idPeca = 1L;
        PecaDAO pecaDAO = new PecaDAO();
        Peca pecaExistente = pecaDAO.buscarPecaPorId(idPeca);
        if (pecaExistente == null) {
            System.out.println("Peca não encontrada.");
        }

        long idProblema = 1L;
        ProblemasExistentesDAO problemasExistentesDAO = new ProblemasExistentesDAO();
        ProblemasExistentes problemas = problemasExistentesDAO.buscarProblemaPorId(idProblema);
        if (problemas == null) {
            System.out.println("Problema não encontrado.");
        }

        Diagnostico diagnostico = new Diagnostico(cliente, veiculo, problemas, guincho );
        dao.adicionarDiagnostico(diagnostico);

        Agendamento agendamentoNovo = new Agendamento(diagnostico, "13/11/11", "18:00", oficina);
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
            System.out.println("ID Diagnostico: " + agendamento.getDiagnostico().getIdDiagnostico());
            System.out.println("ID Oficina: " + agendamento.getOficina().getIdOficina());
            System.out.println("Data: " + agendamento.getData());
            System.out.println("Hora: " + agendamento.getHora());
            System.out.println("Oficina: " + agendamento.getOficina().getNomeOficina());
            System.out.println("Descrição: " + agendamento.getDiagnostico().getDescricao());
            System.out.println("------------");
        }
    }

    @Test
    public void deletarAgendamento(){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.deletarAgendamento(2L);
    }





}
