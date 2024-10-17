package quantumleap.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Peca {

    private Long idPeca;
    @JsonProperty
    private String nomePeca;
    @JsonProperty
    private double precoPeca;
    @JsonProperty
    private String marcaPeca;
    @JsonProperty
    private String modeloPeca;


    public Peca(String nomePeca, double precoPeca, String marcaPeca, String modeloPeca) {
        this.nomePeca = nomePeca;
        this.precoPeca = precoPeca;
        this.marcaPeca = marcaPeca;
        this.modeloPeca = modeloPeca;
    }

    public Peca(){

    }


    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public double getPrecoPeca() {
        return precoPeca;
    }

    public void setPrecoPeca(double precoPeca) {
        this.precoPeca = precoPeca;
    }

    public String getMarcaPeca() {
        return marcaPeca;
    }

    public void setMarcaPeca(String marcaPeca) {
        this.marcaPeca = marcaPeca;
    }

    public String getModeloPeca() {
        return modeloPeca;
    }

    public void setModeloPeca(String modeloPeca) {
        this.modeloPeca = modeloPeca;
    }

}
