package br.com.bb9leko;

import br.com.bb9leko.controleacoes.dto.Evento;
import br.com.bb9leko.controleacoes.model.Transacao;

import java.util.ArrayList;
import java.time.LocalDate;

public class TestesTransacao {

    public static void main(String[] args) {

        Transacao transacao1 = new Transacao();
        //transacao1.setDataEvento(new Date(2024, 10, 10));
        transacao1.setCompraOUVenda(Evento.COMPRA);
        transacao1.setTicket("PETR4");
        transacao1.setQuantidade(100);
        transacao1.setValorUnitario(27.23);
        transacao1.setValorCorretagem(4.90);
        transacao1.setValorTaxasEmolumentos(0.51);



        Transacao transacao2 = new Transacao();
        transacao2.setDataEvento(LocalDate.of(2024, 10, 23));
        transacao2.setCompraOUVenda(Evento.VENDA);
        transacao2.setTicket("TAEE11");
        transacao2.setQuantidade(100);
        transacao2.setValorUnitario(7.23);
        transacao2.setValorCorretagem(4.90);
        transacao2.setValorTaxasEmolumentos(0.51);

        //Com Construtor na classe
        //Transacao transacao1 = new Transacao(new Date(2024, 10,10),
        //        //        "PETR4" , 100, 4.90, 0.50, 27.23, Evento.COMPRA, "BBDTVM");

        //Transacao transacao2 = new Transacao(new Date(2024, 12,23),
        //        "AURE3" , 100, 4.90, 0.50, 7.23, Evento.COMPRA, "CLEAR");


        System.out.println(transacao1.toString());
        System.out.println(transacao2.toString());

        ArrayList<Transacao> listaTransacoes = new ArrayList<>();
        listaTransacoes.add(transacao1);
        listaTransacoes.add(transacao2);
        System.out.println("Tamanho da lista: " + listaTransacoes.size());
        System.out.println("Primeiro ticket da lista: " + listaTransacoes.get(0).getTicket());
        System.out.println(listaTransacoes);
        System.out.println("toString da transacao1: " + listaTransacoes.get(0).toString());




    }
}
