package br.com.bb9leko.fundamentals.heranca;

import java.util.ArrayList;

public class TestFundamentals {

    public static void main(String[] args) {




        Investimento investimento = new Investimento("Banco do Brasil S.A", "BBAS3");
//        investimento.setNome("Banco do Brasil S.A");
//        investimento.setNomeResumido("BBSA3");
        System.out.println(investimento.getNome());

        RendaVariavel rendaVariavel = new RendaVariavel("Banco do Brasil S.A", "BBAS3");
//        rendaVariavel.setNome("Banco do Brasil S.A");
//        rendaVariavel.setNomeResumido("BBAS3");
//        rendaVariavel.setSetor("Financeiro");
//        rendaVariavel.setSubSetor("Bancos");
        System.out.println(rendaVariavel.toString());

        RendaVariavel rendaVariavel2 = new RendaVariavel("Banco Bradesco", "BBDC4");

        RendaFixa rendaFixa = new RendaFixa("Banco do Brasil - Referenciado Longo Prazo Mega", "BB Ref LP MEGA");

        ArrayList<Investimento> investimentos = new ArrayList<>();
        investimentos.add(rendaVariavel);
        investimentos.add(rendaVariavel2);
        investimentos.add(rendaFixa);

        for (Investimento inv : investimentos) {
            System.out.println(inv.getNome());
        }


    }
}
