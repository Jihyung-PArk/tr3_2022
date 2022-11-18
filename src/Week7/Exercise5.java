package Week7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);


        int[] numArray;
        int[] newArray;
        int count = 0;
        int input;

        numArray = new int[100];

        System.out.println("Enter your number up to 100 ( 0 : End )");
        try{
            while (true){
                input = myObj.nextInt();

                if (input <= 0){
                    break;
                }
                numArray[count] = input;
                count++;
            }

            numSorts(numArray, count);

            System.out.println("Result :");
            for (int i = 0; i < count; i++) {
                System.out.println( numArray[i] );
            }
        }catch (InputMismatchException e)
        {
            System.out.println("Not a number! Try again");

        }


    }

    private static void numSorts(int[] numArray, int count) {
        for (int lastPlace = count-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;

            for (int j = 1; j <= lastPlace; j++) {
                if (numArray[j] > numArray[maxLoc]) {

                    maxLoc = j;
                }


                int temp = numArray[maxLoc];
                numArray[maxLoc] = numArray[lastPlace];
                numArray[lastPlace] = temp;
            }
            System.out.println(numArray[lastPlace]);
        }
    }
}
