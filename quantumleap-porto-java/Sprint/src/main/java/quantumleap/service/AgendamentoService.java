package quantumleap.service;

import quantumleap.dominio.Agendamento;
import quantumleap.dominio.RepositorioAgentamento;

import java.util.ArrayList;

public class AgendamentoService {

    private RepositorioAgentamento repositorioAgentamento;

    public AgendamentoService(RepositorioAgentamento repositorioAgentamento){
        this.repositorioAgentamento = repositorioAgentamento;
    }

    public void adicionar(Agendamento agendamento){
        repositorioAgentamento.adicionarAgendamento(agendamento);
        repositorioAgentamento.fecharConexao();
    }

    public Agendamento buscarPorId(long idAgendamento){
        Agendamento agendamento = repositorioAgentamento.buscarAgendamentoPorId(idAgendamento);
        repositorioAgentamento.fecharConexao();
        return agendamento;
    }

    public void atualizarAgendamento(long idAgendamento, Agendamento agendamento){
        repositorioAgentamento.atualizarAgendamento(idAgendamento, agendamento);
        repositorioAgentamento.fecharConexao();
    }

    public void deletarAgendamento(long idAgendamento){
        repositorioAgentamento.deletarAgendamento(idAgendamento);
        repositorioAgentamento.fecharConexao();
    }

    public ArrayList<Agendamento> listarAgendamentos(){
        ArrayList<Agendamento> listaAgendamentos = repositorioAgentamento.listarAgendamentos();
        repositorioAgentamento.fecharConexao();
        return listaAgendamentos;
    }
}
