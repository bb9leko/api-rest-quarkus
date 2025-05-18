package br.com.bb9leko.fundamentals;

public class RendaVariavel extends Investimento {

    private String setor;
    private String subSetor;
    private double cotacao;

    public RendaVariavel(String nome, String nomeResumido) {
        super(nome, nomeResumido);
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSubSetor() {
        return subSetor;
    }

    public void setSubSetor(String subSetor) {
        this.subSetor = subSetor;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    @Override
    public String toString() {
        return "RendaVariavel{" +
                "setor='" + setor + '\'' +
                ", subSetor='" + subSetor + '\'' +
                ", cotacao=" + cotacao +
                '}';
    }
}
