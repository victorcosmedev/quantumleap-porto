package dominio;

import org.junit.jupiter.api.Test;
import quantumleap.dominio.*;
import quantumleap.infra.dao.DiagnosticoDAO;

import java.text.ParseException;
import java.util.ArrayList;

public class DiagnosticoDAOTest {

    @Test
    public void adicionandoDiagnostico() throws ParseException {
        DiagnosticoDAO dao = new DiagnosticoDAO();
        //Diagnostico 1:

        Diagnostico diagnostico = new Diagnostico(1L, 1L, 1L, 1L );
        dao.adicionarDiagnostico(diagnostico);

        //Diagnostico 2:

        Diagnostico diagnostico2 = new Diagnostico(2L, 2L, 2L, 2L );
        dao.adicionarDiagnostico(diagnostico2);
    }

    @Test
    public void buscarDiagnostico() {
        DiagnosticoDAO dao = new DiagnosticoDAO();
        long idDiag = 6L;
        Diagnostico diagnostico = dao.buscarDiagnosticoPorId(idDiag);

        if (diagnostico == null) {
            System.out.println("Diagnostico não encontrado.");
        }else {
            System.out.println("ID: " + diagnostico.getIdDiagnostico());
            System.out.println("ID Cliente: "+ diagnostico.getIdCliente());
            System.out.println("ID Veiculo: "+ diagnostico.getIdVeiculo());
            System.out.println("ID Problema: "+ diagnostico.getIdProblemasExistentes());
            System.out.println("ID Guincho: "+ diagnostico.getIdGuincho());
        }
    }

    @Test
    public void atualizarDiagnostico() throws ParseException {
        DiagnosticoDAO dao = new DiagnosticoDAO();
        Diagnostico diagnostico = new Diagnostico(3L, 3L, 3L, 3L );
        dao.atualizarDiagnostico(5L,diagnostico);
    }

    @Test
    public void listarDiagnosticos() {
        DiagnosticoDAO dao = new DiagnosticoDAO();
        ArrayList<Diagnostico> diagnosticos = dao.listarDiagnosticos();

        for (Diagnostico diagnostico : diagnosticos) {
            System.out.println("Diagnóstico ID: " + diagnostico.getIdDiagnostico());
            System.out.println("Cliente ID: " + diagnostico.getIdCliente());
            System.out.println("Veículo ID: " + diagnostico.getIdVeiculo());
            System.out.println("Problemas Existentes ID: " + diagnostico.getIdProblemasExistentes());
            System.out.println("Guincho ID: " + diagnostico.getIdGuincho());
            System.out.println("-----------------------------");
        }
    }

    @Test
    public void deletarDiagnostico() throws ParseException {
        DiagnosticoDAO dao = new DiagnosticoDAO();
        long idDiag = 5L;
        Diagnostico diagnostico = dao.buscarDiagnosticoPorId(idDiag);
        if (diagnostico == null) {
            System.out.println("Diagnostico não encontrado.");
        }else {
            System.out.println("Diagnostico encontrado.");
            dao.deletarDiagnostico(idDiag);
        }

    }



}

