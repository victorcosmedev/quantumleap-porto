package quantumleap.service;

import quantumleap.dominio.Peca;
import quantumleap.dominio.RepositorioPeca;

import java.util.ArrayList;

public class PecaService {
    private RepositorioPeca repositorioPeca;

    public PecaService(RepositorioPeca repositorioPeca) {
        this.repositorioPeca = repositorioPeca;
    }

    public void adicionar(Peca peca){
        repositorioPeca.adicionaPeca(peca);
        repositorioPeca.fechar();
    }

    public Peca buscarPorId(Long id){
        Peca peca = repositorioPeca.buscarPecaPorId(id);
        repositorioPeca.fechar();
        return peca;
    }

    public void alterarPeca(Long id, Peca peca){
        repositorioPeca.atualizarPeca(id, peca);
        repositorioPeca.fechar();
    }

    public void removerPeca(Long id){
        repositorioPeca.removerPeca(id);
        repositorioPeca.fechar();
    }

    public ArrayList<Peca> listarPecas(){
        ArrayList<Peca> pecas = repositorioPeca.listarPeca();
        repositorioPeca.fechar();
        return pecas;

    }


}
