package quantumleap.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {
    private Long idCliente;
    @JsonProperty
    private String nomeCliente;
    @JsonProperty
    private String emailCliente;
    @JsonProperty
    private String telefoneCliente;
    @JsonProperty
    private String senhaCliente;
    @JsonProperty
    private boolean clientePorto;
    @JsonProperty
    private String localizacaoCliente;

    public Cliente(String nomeCliente, String emailCliente, String telefoneCliente, String senhaCliente, boolean clientePorto, String localizacaoCliente){
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.clientePorto = clientePorto;
        this.localizacaoCliente = localizacaoCliente;
    }

    public Cliente() {}

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }



    public boolean getClientePorto() {
        return clientePorto;
    }

    public void setClientePorto(boolean clientePorto) {
        this.clientePorto = clientePorto;
    }






    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }


    public String getLocalizacaoCliente() {
        return localizacaoCliente;
    }

    public void setLocalizacaoCliente(String localizacaoCliente) {
        this.localizacaoCliente = localizacaoCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }


}
