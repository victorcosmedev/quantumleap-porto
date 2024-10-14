package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioPeca {

    public void adicionaPeca(Peca peca);
    public Peca buscarPecaPorId(Long idPeca);
    public void atualizarPeca(long idPeca, Peca peca);
    public void removerPeca(Long idPeca);
    public ArrayList<Peca> listarPeca();
    public void fechar();
}
