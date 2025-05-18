package br.com.bb9leko.controleacoes.model;

public enum Evento {
    COMPRA("compra"),
    VENDA("venda");

    private final String descricao;

    Evento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
