package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioAgentamento {

    public void adicionarAgendamento(Agendamento agendamento);
    public Agendamento buscarAgendamentoPorId(long idAgendamento);
    public void atualizarAgendamento(long idAgendamento, Agendamento agendamento);
    public void deletarAgendamento(Long idAgendamento);
    public ArrayList<Agendamento> listarAgendamentos();
    public void fecharConexao();

}
