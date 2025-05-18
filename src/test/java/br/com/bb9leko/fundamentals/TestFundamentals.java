package br.com.bb9leko.fundamentals;

import java.util.ArrayList;

public class TestFundamentals {

    public static void main(String[] args) {

        int i = 0;
        loop:
        {
            System.out.println("Loop Lable line");
            try {
                for (; true; i++) {
                    if (i > 5)
                        break loop;
                }
            } catch (Exception e) {
                System.out.println("Exception in loop.");
            } finally {
                System.out.println("In Finally");
            }
        }

//        int k = 9, s = 5;
//        switch (k) {
//            default:
//                if (k == 10) {
//                    s = s * 2;
//                } else {
//                    s = s + 4;
//                    break;
//                }
//            case 7:
//                s = s + 3;
//        }
//        System.out.println(s);

//        int a = 5, b = 2, c = 30;
//        System.out.println(a + ++b * c);


//        int[] arr = {1, 2, 3, 4, 5, 6};
//        int counter = 0;
//        for (int value : arr) {
//            if (counter >= 5) {
//                break;
//            } else {
//                continue;
//            }
//            if (value > 4) {
//                arr[counter] = value + 1;
//            }
//            counter++;
//        }
//        System.out.println(arr[counter]);


//        ArrayList<String> al = new ArrayList<String>();
//        al.add("111");
//        al.add("222");
//        System.out.println(al.get(al.size()));

//        int i = 0, j = 0;
//        X1:
//        for (i = 0; i < 3; i++) {
//            X2:
//            for (j = 3; j > 0; j--) {
//                if (i < j) continue X1;
//                else break X2;
//            }
//        }
//        System.out.println(i + " " + j);


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
