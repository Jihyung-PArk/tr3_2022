package week4;

import java.util.Scanner;

public class Question13 {

    public static double average (double [] num, int N){

        double sum = 0;

        if ( N < 1 || N > num.length){
            var message = String.format("Out of range");
            throw new IllegalArgumentException(message);
        }

        for (int i = 0; i < N; i++){
            sum = sum + num[i];
        }

        return sum/N;
    }


    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter double [] and number N");
        System.out.print("Enter double [] : ");
        double doubleOutPut = myObj.nextDouble();
        System.out.print("Enter number : ");
        int intOupPut = myObj.nextInt();

        try {
            System.out.println("Your double is " + doubleOutPut + " and number is " + intOupPut);
            System.out.println("Result is " + average(new double[]{doubleOutPut}, intOupPut));
        }catch (IllegalArgumentException e){
            System.out.println("Error : " + e.getLocalizedMessage());}
    }
}
