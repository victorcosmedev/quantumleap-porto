package quantumleap.dominio;

public class Guincho {
    private long idGuincho;
    private String placa;
    private double preco;
    private double cargaMaxima;




    public Guincho(String placa, double preco, double cargaMaxima) {
        this.placa = placa;
        this.preco = preco;
        this.cargaMaxima = cargaMaxima;
    }

    public Guincho(){}

    public double getPreco(){
        return preco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public long getIdGuincho() {
        return idGuincho;
    }

    public void setIdGuincho(long idGuincho) {
        this.idGuincho = idGuincho;
    }
}