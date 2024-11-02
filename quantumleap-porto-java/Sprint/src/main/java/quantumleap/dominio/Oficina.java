package quantumleap.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Oficina {
    private long idOficina;
    @JsonProperty
    private String nomeOficina;
    @JsonProperty
    private String localizacaoOficina;
    @JsonProperty
    private String telefoneOficina;
    @JsonProperty
    private String emailOficina;

    public Oficina(String nomeOficina, String localizacaoOficina, String telefoneOficina, String emailOficina) {
        this.nomeOficina = nomeOficina;
        this.localizacaoOficina = localizacaoOficina;
        this.telefoneOficina = telefoneOficina;
        this.emailOficina = emailOficina;

    }

    public Oficina(){}

    public void setIdOficina(long idOficina) {
        this.idOficina = idOficina;
    }

    public long getIdOficina() {
        return idOficina;
    }

    public String getNomeOficina() {
        return nomeOficina;
    }

    public void setNomeOficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }

    public void setLocalizacaoOficina(String localizacaoOficina) {
        this.localizacaoOficina = localizacaoOficina;
    }

    public String getTelefoneOficina() {
        return telefoneOficina;
    }

    public void setTelefoneOficina(String telefoneOficina) {
        this.telefoneOficina = telefoneOficina;
    }

    public String getEmailOficina() {
        return emailOficina;
    }

    public void setEmailOficina(String emailOficina) {
        this.emailOficina = emailOficina;
    }

    public String getLocalizacaoOficina() {
        return localizacaoOficina;
    }
}


