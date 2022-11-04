package Week1;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("How many quarters do you have?");
        int quarter = myObj.nextInt();
        System.out.println("How many dimes do you have?");
        int dime = myObj.nextInt();
        System.out.println("How many nickels do you have?");
        int nickel = myObj.nextInt();
        System.out.println("How many pennies do you have?");
        int penny = myObj.nextInt();

        double totalChange = ((quarter * 0.25) + (dime * 0.1) + (nickel * 0.05) + (penny * 0.01));


        System.out.print("Total in dollars is $");
        System.out.printf("%.2f", totalChange);




    }
}
