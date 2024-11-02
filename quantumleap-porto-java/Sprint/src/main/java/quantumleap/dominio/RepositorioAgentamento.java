package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioAgentamento {

    void adicionarAgendamento(Agendamento agendamento);
    Agendamento buscarAgendamentoPorId(long idAgendamento);
    void atualizarAgendamento(long idAgendamento, Agendamento agendamento);
    void deletarAgendamento(Long idAgendamento);
    ArrayList<Agendamento> listarAgendamentos();
    void fecharConexao();

}
