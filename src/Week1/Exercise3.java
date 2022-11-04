package Week1;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        String name = myObj.nextLine();
        String upperCaseName = name.toUpperCase();


        System.out.println("What is your name?");
        System.out.println("Hello, " + upperCaseName + ", nice to meet you!");

    }
}
