package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioProblemasExistentes {
    public void adicionarProblemaExistente(ProblemasExistentes problema);
    public ProblemasExistentes buscarProblemaPorId(long idProblema);
    public void atualizarProblemaExistente(long idProblema, ProblemasExistentes problema);
    public ArrayList<ProblemasExistentes> listarProblemasExistentes();
    public void deletarProblemaExistente(long idProblema);
    public void fecharConexao();

}
