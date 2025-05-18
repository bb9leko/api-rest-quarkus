package br.com.bb9leko.analiseacoes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "acoes")
public class Acoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="papel")
    private String papel;
    @Column(name="cotacao")
    private String cotacao;
    @Column(name="P/VP")
    private String pvp;
    @Column(name="P/L")
    private String pl;

    public Acoes() {
    }

    public Acoes(DadosAcoes dados) {
        this.papel = dados.papel();
        this.cotacao = dados.cotacao();
        this.pvp = dados.pvp();
        this.pl = dados.pl();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getCotacao() {
        return cotacao;
    }

    public void setCotacao(String cotacao) {
        this.cotacao = cotacao;
    }

    public String getPvp() {
        return pvp;
    }

    public void setPvp(String pvp) {
        this.pvp = pvp;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", papel='" + papel + '\'' +
                ", cotacao=" + cotacao +
                ", pvp=" + pvp +
                ", pl=" + pl +
                '}';
    }
}
