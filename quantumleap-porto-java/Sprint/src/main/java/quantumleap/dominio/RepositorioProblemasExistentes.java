package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioProblemasExistentes {
    void adicionarProblemaExistente(ProblemasExistentes problema);
    ProblemasExistentes buscarProblemaPorId(long idProblema);
    void atualizarProblemaExistente(long idProblema, ProblemasExistentes problema);
    ArrayList<ProblemasExistentes> listarProblemasExistentes();
    void deletarProblemaExistente(long idProblema);
    void fecharConexao();

}
