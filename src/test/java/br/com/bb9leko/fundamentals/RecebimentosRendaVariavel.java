package br.com.bb9leko.fundamentals;

public class RecebimentosRendaVariavel {

    private String dataRecebimento;
    private double valorRecebido;
    private String tipoRecebimento;
    private RendaVariavel rendaVariavel;

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public RendaVariavel getRendaVariavel() {
        return rendaVariavel;
    }

    public void setRendaVariavel(RendaVariavel rendaVariavel) {
        this.rendaVariavel = rendaVariavel;
    }

    public String getTipoRecebimento() {
        return tipoRecebimento;
    }

    public void setTipoRecebimento(String tipoRecebimento) {
        this.tipoRecebimento = tipoRecebimento;
    }
}
