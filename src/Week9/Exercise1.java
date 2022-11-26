package Week9;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        int fibonacciInput;

        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter your number for fibonacci");
        fibonacciInput = myObj.nextInt();

        if(fibonacciInput < 0){
            System.out.println("Wrong number. Number must be positive number.");
        }
    }

    public long fibonacci(long n){
        if ( n == 1 ){
            return 1;
        }else {
            return n + (fibonacci(n-1));
        }
    }
    public long factorial(long n){

        if (n == 1){
            return 1;
        }else {
            return n * (factorial(n-1));
        }

    }
}
