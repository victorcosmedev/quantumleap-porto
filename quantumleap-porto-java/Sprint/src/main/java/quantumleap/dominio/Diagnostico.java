package quantumleap.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Diagnostico {
    private long idDiagnostico;

    @JsonProperty
    private long idCliente;

    @JsonProperty
    private long idVeiculo;

    @JsonProperty
    private long idProblemasExistentes;

    @JsonProperty
    private long idGuincho;


    public Diagnostico(long idCliente, long idVeiculo, long idProblemasExistentes, long idGuincho) {
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
        this.idProblemasExistentes = idProblemasExistentes;
        this.idGuincho = idGuincho;
    }

    public Diagnostico() {}

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public long getIdProblemasExistentes() {
        return idProblemasExistentes;
    }

    public void setIdProblemasExistentes(long idProblemasExistentes) {
        this.idProblemasExistentes = idProblemasExistentes;
    }

    public long getIdGuincho() {
        return idGuincho;
    }

    public void setIdGuincho(long idGuincho) {
        this.idGuincho = idGuincho;
    }

    public long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

}
