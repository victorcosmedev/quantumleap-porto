package quantumleap.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Agendamento {
    private long idAgendamento;
    @JsonProperty
    private long idDiagnostico;
    @JsonProperty
    private String data;
    @JsonProperty
    private String hora;
    @JsonProperty
    private String localizacao;
    @JsonProperty
    private String descricao_agendamento;
    @JsonProperty
    private long idOficina;


    public Agendamento(long idDiagnostico, String data, String hora, long idOficina) {
        this.idDiagnostico = idDiagnostico;
        this.data = data;
        this.hora = hora;
        this.idOficina = idOficina;
    }


    public Agendamento(){}

    public long getIdOficina() {
        return idOficina;
    }



    public long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public String getData() {
        return data;
    }

    public String getHora(){
        return hora;
    }

    public void setLocalizacao(String localizacao){
        this.localizacao = localizacao;
    }

    public String getLocalizacao(){
        return localizacao;
    }

    public long getIdDiagnostico() {
        return idDiagnostico;
    }

    public String getDescricao_agendamento() {
        return descricao_agendamento;
    }

    public void setDescricao_agendamento(String descricao_agendamento) {
        this.descricao_agendamento = descricao_agendamento;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }



}
