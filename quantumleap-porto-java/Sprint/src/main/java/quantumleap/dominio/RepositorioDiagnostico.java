package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioDiagnostico {
    public void adicionarDiagnostico(Diagnostico diagnostico);
    public Diagnostico buscarDiagnosticoPorId(Long idDiagnostico);
    public void atualizarDiagnostico(long idDiagnostico, Diagnostico novoDiagnostico);
    public void deletarDiagnostico(Long idDiagnostico);
    public ArrayList<Diagnostico> listarDiagnosticos();
    public void fecharConexao();
}
