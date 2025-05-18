package br.com.bb9leko.controleacoes.model;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate dataEvento;
    private String ticket;
    private int quantidade;
    private double valorCorretagem;
    private double valorTaxasEmolumentos;
    private double valorUnitario;
    private BigDecimal valorTotal;
    @Enumerated(EnumType.STRING)
    private Evento compraOUVenda;
    private String corretora;

    public Transacao() {
    }

    @PrePersist
    @PreUpdate
    private void calcularValorTotal() {
        this.valorTotal = BigDecimal.valueOf(this.valorUnitario * this.quantidade);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public BigDecimal getValorTotal() {
        return BigDecimal.valueOf(this.valorUnitario * this.quantidade);
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public Evento getCompraOUVenda() {
        return compraOUVenda;
    }

    public void setCompraOUVenda(Evento compraOUVenda) {
        this.compraOUVenda = compraOUVenda;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "dataEvento=" + dataEvento +
                ", ticket='" + ticket + '\'' +
                ", quantidade=" + quantidade +
                ", valorCorretagem=" + valorCorretagem +
                ", valorTaxasEmolumentos=" + valorTaxasEmolumentos +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                ", compraOUVenda=" + compraOUVenda +
                ", corretora='" + corretora + '\'' +
                '}';
    }
}
