package dominio;

import org.junit.jupiter.api.Test;
import quantumleap.infra.*;
import quantumleap.dominio.*;

import java.text.ParseException;
import java.util.ArrayList;

public class DiagnosticoDAOTest {

    @Test
    public void adicionandoDiagnostico() throws ParseException {
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

        //Diagnostico 2:

        Cliente cliente2 = new Cliente("ClienteTest1", "6@gmail.com", "11111111111", "senhaclientetest", true, "São Paulo");

        clienteDAO.adicionarCliente(cliente2);


        Veiculo ve1 = new Veiculo("vw", "123", DateUtil.parseYear("2002"), 123, "1233");
        veiculoDAO.adicionarVeiculo(cliente, ve1);


        Long idPecaExistente = 1L;
        Peca pecaExistente2 = pecaDAO.buscarPecaPorId(idPecaExistente);

        Guincho guincho2 = new Guincho("Guinc3", 1000, 100000);
        guinchoDAO.adicionaGuincho(guincho2);


        ProblemasExistentes problema = new ProblemasExistentes("Teste2", "Teste", 100, 2, pecaExistente2);
        problemasExistentesDAO.adicionarProblemaExistente(problema);

        Diagnostico diagnostico2 = new Diagnostico(cliente, ve1, problema, guincho );
        dao.adicionarDiagnostico(diagnostico2);
    }

    @Test
    public void buscarDiagnostico() {
        DiagnosticoDAO dao = new DiagnosticoDAO();
        long idDiag = 1L;
        Diagnostico diagnostico = dao.buscarDiagnosticoPorId(idDiag);

        if (diagnostico == null) {
            System.out.println("Diagnostico não encontrado.");
        }else {
            System.out.println("ID: " + diagnostico.getIdDiagnostico());
            System.out.println("ID Cliente: "+ diagnostico.getCliente().getIdCliente());
            System.out.println("ID Veiculo: "+ diagnostico.getVeiculo().getIdVeiculo());
            System.out.println("ID Problema: "+ diagnostico.getProblemasExistentes().getIdProblemas());
            System.out.println("ID Guincho: "+ diagnostico.getGuincho().getIdGuincho());
        }
    }

    @Test
    public void atualizarDiagnostico() throws ParseException {
        DiagnosticoDAO dao = new DiagnosticoDAO();

        Cliente cliente3 = new Cliente("ClienteAtualizado", "ClienteAtualizado1@gmail.com", "11111111111", "senhaclientetest", true, "São Paulo");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.adicionarCliente(cliente3);


        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo ve1 = new Veiculo("vw", "123", DateUtil.parseYear("2002"), 123, "1233");

        veiculoDAO.adicionarVeiculo(cliente3, ve1);

        Peca peca = new Peca("Peça", 100, "teste", "teste");
        PecaDAO pecaDAO = new PecaDAO();
        pecaDAO.adicionaPeca(peca);
        Long idPecaExistente = 3L;
        Peca pecaExistente = pecaDAO.buscarPecaPorId(idPecaExistente);

        Guincho guincho = new Guincho("NOVODI", 1000, 100000);
        GuinchoDAO guinchoDAO = new GuinchoDAO();
        guinchoDAO.adicionaGuincho(guincho);


        ProblemasExistentesDAO problemasExistentesDAO = new ProblemasExistentesDAO();
        ProblemasExistentes problema = new ProblemasExistentes("NOVODIAG", "Teste", 100, 2, pecaExistente);
        problemasExistentesDAO.adicionarProblemaExistente(problema);

        Diagnostico diagnostico = new Diagnostico(cliente3, ve1, problema, guincho );

        dao.atualizarDiagnostico(1L,diagnostico);


    }

    @Test
    public void listarDiagnosticos() {
        DiagnosticoDAO dao = new DiagnosticoDAO();
        ArrayList<Diagnostico> diagnosticos = dao.listarDiagnosticos();

        for (Diagnostico diagnostico : diagnosticos) {
            System.out.println("Diagnóstico ID: " + diagnostico.getIdDiagnostico());
            System.out.println("Cliente ID: " + diagnostico.getCliente().getIdCliente());
            System.out.println("Veículo ID: " + diagnostico.getVeiculo().getIdVeiculo());
            System.out.println("Problemas Existentes ID: " + diagnostico.getProblemasExistentes().getIdProblemas());
            System.out.println("Guincho ID: " + diagnostico.getGuincho().getIdGuincho());
            System.out.println("-----------------------------");
        }
    }

    @Test
    public void deletarDiagnostico() throws ParseException {
        DiagnosticoDAO dao = new DiagnosticoDAO();
        long idDiag = 2L;
        Diagnostico diagnostico = dao.buscarDiagnosticoPorId(idDiag);
        if (diagnostico == null) {
            System.out.println("Diagnostico não encontrado.");
        }else {
            System.out.println("Diagnostico encontrado.");
            dao.deletarDiagnostico(idDiag);
        }

    }



}

