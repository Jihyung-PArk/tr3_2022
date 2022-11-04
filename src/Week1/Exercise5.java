package Week1;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("How many eggs do you have?");
        int egg = myObj.nextInt();

        int gross = egg / 144;
        int afterGross = egg % 144;
        int dozen = afterGross / 12;
        int afterDozen = afterGross % 12;

        System.out.println(" Your number of egg is " + gross + " gross, " + dozen + " dozen, and " + afterDozen);

    }
}
