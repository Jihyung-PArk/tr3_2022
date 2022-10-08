package week4;

import java.util.Scanner;

public class Exercise3 {

    public static int pairDice(int num){
        if (num < 2 || num > 12) {
            var message = String.format("Out of range");
            throw new IllegalArgumentException(message);
        }

        int count = 0;
        int totalDice = 1;

        while (totalDice != num){
            int dice1 = (int) (6*Math.random() + 1);
            int dice2 = (int) (6*Math.random() + 1);
            totalDice = dice1 + dice2;

            count ++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        try {
            System.out.println("Choose your number between 2 - 12");
            System.out.print("What is your number : ");


            int num = myObj.nextInt();

            int value = pairDice(num);

            System.out.println("Total " + value + "times rolled a pair.");
        }catch (IllegalArgumentException e){
            System.out.println("Error : " + e.getLocalizedMessage());
        }
    }

}
