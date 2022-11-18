package Week8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        double A;
        double B;
        double C;
        double answer;

        System.out.println("equation");
        System.out.println("(-B + sqrt(B*B - 4*A*C)) / (2*A)");

        try{
        System.out.print("Enter your A value :");
        A = myObj.nextDouble();
        System.out.print("Enter your B value : ");
        B = myObj.nextDouble();
        System.out.print("Enter your C value : ");
        C = myObj.nextDouble();

        try {
            answer = root(A, B, C);
            System.out.println("Your equation result is " + answer);
            System.out.println();
        }catch (IllegalArgumentException e){
            System.out.println("Your value(s) is wrong");
            System.out.println(e.getMessage());

        }



        }catch (InputMismatchException e)
        {
            System.out.println("Not a number! Try again");


        }

    }

    static public double root( double A, double B, double C )
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }
}
