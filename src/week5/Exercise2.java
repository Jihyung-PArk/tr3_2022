package week5;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        StatCalc statCalc = new StatCalc();
        double num;


        System.out.println("Enter number. (if number is zero, system end.");

        do{
            System.out.print("What is your number?");
            num = myObj.nextDouble();

            if(num != 0){
                statCalc.enter(num);
            }
        }
        while (num != 0);


        System.out.println("Result");
        System.out.println("Count:" + statCalc.getCount());
        System.out.println("Sum:" + statCalc.getSum());
        System.out.println("Average:" + statCalc.getMean());
        System.out.println("Standard Deviation:" + statCalc.getStandardDeviation());
        System.out.println("Minimum:" + statCalc.getMin());
        System.out.println("Maximum:" + statCalc.getMax());

    }

}
