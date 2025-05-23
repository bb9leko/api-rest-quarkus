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

//int i = 0;
//loop:
//        {
//        System.out.println("Loop Lable line");
//            try {
//                    for (; true; i++) {
//        if (i > 5)
//        break loop;
//                }
//                        } catch (Exception e) {
//        System.out.println("Exception in loop.");
//            } finally {
//                    System.out.println("In Finally");
//            }
//                    }

//new Node().print(); //2

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





