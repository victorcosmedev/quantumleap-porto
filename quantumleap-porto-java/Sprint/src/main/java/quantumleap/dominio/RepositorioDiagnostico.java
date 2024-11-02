package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioDiagnostico {
    void adicionarDiagnostico(Diagnostico diagnostico);
    Diagnostico buscarDiagnosticoPorId(Long idDiagnostico);
    void atualizarDiagnostico(long idDiagnostico, Diagnostico novoDiagnostico);
    void deletarDiagnostico(Long idDiagnostico);
    ArrayList<Diagnostico> listarDiagnosticos();
    void fecharConexao();
}
