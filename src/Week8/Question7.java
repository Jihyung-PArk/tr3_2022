package Week8;

public class Question7 {
    private static void threeNSequnce(int num) {

        int count = 0;

        assert num >= 1 : " number value must be bigger than 1.";

        System.out.println("3N+1 sequence starting with \" + num + \" is:");

        do {
            System.out.println(num);
            count++;
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                assert  num <= 2147483646/3 : "Number is too large.";
                num = 3 * num + 1;
            }
        }
        while (num != 1);

        System.out.println(num);
        System.out.println("There were " + count + " terms in the sequence.");

    }
}
