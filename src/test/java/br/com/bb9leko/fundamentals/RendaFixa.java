package br.com.bb9leko.fundamentals;

public class RendaFixa extends Investimento {

    private String rentabilidade;
    double valorAplicado;

    public RendaFixa(String nome, String nomeResumido) {
        super(nome, nomeResumido);
    }

    public String getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(String rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public double getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(double valorAplicado) {
        this.valorAplicado = valorAplicado;
    }

}
