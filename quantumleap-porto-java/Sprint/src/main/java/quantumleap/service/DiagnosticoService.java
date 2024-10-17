package quantumleap.service;

import quantumleap.dominio.Diagnostico;
import quantumleap.dominio.RepositorioDiagnostico;
import quantumleap.infra.DiagnosticoDAO;

import java.util.ArrayList;
import java.util.Date;

public class DiagnosticoService {
    private RepositorioDiagnostico repositorioDiagnostico;

    public DiagnosticoService(RepositorioDiagnostico repositorioDiagnostico){
        this.repositorioDiagnostico = repositorioDiagnostico;
    }

    public void adicionarDiagostico(Diagnostico diagnostico){
        repositorioDiagnostico.adicionarDiagnostico(diagnostico);
        repositorioDiagnostico.fecharConexao();
    }

    public Diagnostico buscarPorID(long id){
        Diagnostico diagnostico = repositorioDiagnostico.buscarDiagnosticoPorId(id);
        repositorioDiagnostico.fecharConexao();
        return diagnostico;
    }

    public void atualizarDiagnostico(long id, Diagnostico diagnostico){
        repositorioDiagnostico.atualizarDiagnostico(id, diagnostico);
        repositorioDiagnostico.fecharConexao();
    }

    public void deletarDiagnostico(long id){
        repositorioDiagnostico.deletarDiagnostico(id);
        repositorioDiagnostico.fecharConexao();
    }

    public ArrayList<Diagnostico> listarDiagnoticos(){
        ArrayList<Diagnostico> diagnosticos = repositorioDiagnostico.listarDiagnosticos();
        repositorioDiagnostico.fecharConexao();
        return diagnosticos;
    }



}
