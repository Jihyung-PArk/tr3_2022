package Week8;

public class Question6 {

    private static void threeNSequnce(int num) {

        int count = 0;

        try {
            if (num < 1) {
                throw new IllegalArgumentException(" number value must be bigger than 1.");

            }

            System.out.println("3N+1 sequence starting with \" + num + \" is:");

            do {
                System.out.println(num);
                count++;
                if (num % 2 == 0) {
                    num = num / 2;
                } else {
                    num = 3 * num + 1;
                }
            }
            while (num != 1);

            System.out.println(num);
            System.out.println("There were " + count + " terms in the sequence.");
        }catch (ArithmeticException e){
            System.out.println("Number is too large.");
        }
    }

}
