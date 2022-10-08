package week3.prac2;

import java.util.Objects;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        double Num1;
        double Num2;
        String Operator;
        double result;


        while(true) {

            System.out.print("Enter your first number : ");
            Num1 = myObj.nextDouble();

            if (Num1 == 0){
                break;
            }

            System.out.print("Enter your Operator( +, -, /, * )  : ");
            Operator = myObj.next();

            System.out.print("Enter your second number : ");
            Num2 = myObj.nextDouble();

            if (Objects.equals(Operator, "+")){
                result = Num1 + Num2;
                System.out.println(result);
            } else if (Objects.equals(Operator, "-")) {
                result = Num1 - Num2;
                System.out.println(result);
            } else if (Objects.equals(Operator, "*")) {
                result = Num1 * Num2;
                System.out.println(result);
            } else if (Objects.equals(Operator, "/")) {
                result = Num1 / Num2;
                System.out.println(result);
            }else{
                System.out.println("Your operator is wrong!");
                System.out.println("Try again.");
            }
        }

        System.out.println("End the program");



    }
}
