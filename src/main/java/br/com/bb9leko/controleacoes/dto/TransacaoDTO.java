package br.com.bb9leko.controleacoes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class TransacaoDTO {

    @JsonProperty("dataEvento")
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate dataEvento;
    @JsonProperty("ticket")
    private String ticket;
    @JsonProperty("quantidade")
    private int quantidade;
    @JsonProperty("valorCorretagem")
    private double valorCorretagem;
    @JsonProperty("valorTaxasEmolumentos")
    private double valorTaxasEmolumentos;
    @JsonProperty("valorUnitario")
    private double valorUnitario;
    @JsonProperty("valorTotal")
    private double valorTotal;
    @JsonProperty("compraOUVenda")
    private String compraOUVenda;
    @JsonProperty("corretora")
    private String corretora;
    @JsonProperty("classificacaoAtivo")
    private String classificacaoAtivo;

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getValorCorretagem() {
        return valorCorretagem;
    }

    public void setValorCorretagem(double valorCorretagem) {
        this.valorCorretagem = valorCorretagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTaxasEmolumentos() {
        return valorTaxasEmolumentos;
    }

    public void setValorTaxasEmolumentos(double valorTaxasEmolumentos) {
        this.valorTaxasEmolumentos = valorTaxasEmolumentos;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCompraOUVenda() {
        return compraOUVenda;
    }

    public void setCompraOUVenda(String compraOUVenda) {
        this.compraOUVenda = compraOUVenda;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public String getClassificacaoAtivo() {
        return classificacaoAtivo;
    }

    public void setClassificacaoAtivo(String classificacaoAtivo) {
        this.classificacaoAtivo = classificacaoAtivo;
    }
}
