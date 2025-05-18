package br.com.bb9leko.fundamentals;

public class Investimento {

    private String nome;
    private String nomeResumido;

    public Investimento(String nome, String nomeResumido) {
        this.nome = nome;
        this.nomeResumido = nomeResumido;
    }

    public String getNomeResumido() {
        return nomeResumido;
    }

    public void setNomeResumido(String nomeResumido) {
        this.nomeResumido = nomeResumido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
