package quantumleap.dominio;

public class ProblemasExistentes {
    private long idProblemas;
    private String nomeProblema;
    private String descricaoProblema;
    private double custoMaoDeObraProblema;
    private int qtdPeca;
    private long idPeca;

    public ProblemasExistentes() {

    }

    public ProblemasExistentes(String nomeProblema, String descricaoProblema, double custoMaoDeObraProblema, int qtdPeca, long idPeca) {
        this.nomeProblema = nomeProblema;
        this.descricaoProblema = descricaoProblema;
        this.custoMaoDeObraProblema = custoMaoDeObraProblema;
        this.qtdPeca = qtdPeca;
        this.idPeca = idPeca;
    }


    public long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(long idPeca) {
        this.idPeca = idPeca;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public void setNomeProblema(String nomeProblema) {
        this.nomeProblema = nomeProblema;
    }

    public void setCustoMaoDeObraProblema(double custoMaoDeObraProblema) {
        this.custoMaoDeObraProblema = custoMaoDeObraProblema;
    }

    public void setQtdPeca(int qtdPeca) {
        this.qtdPeca = qtdPeca;
    }


    public String getDescricaoProblema(){ return descricaoProblema;}

    public int getQtdPeca(){
        return qtdPeca;
    }

    public double getCustoMaoDeObraProblema(){
        return custoMaoDeObraProblema;
    }

    public String getNomeProblema() {
        return nomeProblema;
    }

    public long getIdProblemas() {
        return idProblemas;
    }

    public void setIdProblemas(long idProblemas) {
        this.idProblemas = idProblemas;
    }
}
