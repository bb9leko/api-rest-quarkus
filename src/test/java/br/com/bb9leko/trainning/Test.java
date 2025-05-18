package br.com.bb9leko.trainning;

public class Test {
       public void loopTest(int x){
          loop:
            for (int i = 1; i < 5; i++) {
                for (int j = 1; j < 5; j++) {
                    System.out.println(i);
                    if (x == 0) {
                        continue loop;
                    }
                    System.out.println(j);
                }
            }
        }
        public static void main(String[] args) {

            new Test().loopTest(0); //1

    }
}
        //new Node().print(); //2

//        int a = 1;
//        int[] ia = new int[10];
//        int b = ia[a];
//        int c = b + a;
//        System.out.println(b = c);

//        boolean b1 = false;
//        boolean b2 = false;
//        if (b2 != b1 = !b2) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }

//        {
//            int c = 0;
//            A: for(int i = 0; i < 2; i++)
//            {
//                B: for(int j = 0; j < 2; j++)
//                {
//                 C: for(int k = 0; k < 3; k++)
//                 {
//                     c++;
//                     if(k>j) break;
//                 }
//                }
//            }
//            System.out.println(c);
//        }
//    }





