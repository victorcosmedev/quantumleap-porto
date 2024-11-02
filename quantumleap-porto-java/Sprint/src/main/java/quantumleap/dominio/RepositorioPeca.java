package quantumleap.dominio;

import java.util.ArrayList;

public interface RepositorioPeca {

    void adicionaPeca(Peca peca);
    Peca buscarPecaPorId(Long idPeca);
    void atualizarPeca(long idPeca, Peca peca);
    void removerPeca(Long idPeca);
    ArrayList<Peca> listarPeca();
    void fechar();
}
