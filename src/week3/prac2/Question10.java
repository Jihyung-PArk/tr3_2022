package week3.prac2;

import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter S1 : ");
        String s1 = myObj.nextLine();

        System.out.print("Enter S2 : ");
        String s2 = myObj.nextLine();

        try{
            int x = Integer.parseInt(s1);
            int y = Integer.parseInt(s2);

            int sum = x + y;

            System.out.println("Sum of s1 and s2 is " + sum);
        }catch(NumberFormatException e){
            System.out.println("Error! The values cannot successfully be converted into integers");
        };



    }
}
