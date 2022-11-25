package Week10;

public class TestFactorial {

    public static void main(String[] args) {

        System.out.println(factorial(5));

    }

    static long factorial(long n) {

        //the base case
        if (n == 1) {

            return 1;

            // general case
        } else {
            return n * factorial(n - 1);
        }
    }
}
