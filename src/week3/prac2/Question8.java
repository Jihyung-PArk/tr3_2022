package week3.prac2;


import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter an integer : ");

        int num = myObj.nextInt();

        if (num % 2 == 0) {
            System.out.println("The integer entered is even");
        } else{
            System.out.println("The integer entered is odd");
        }

        String str = num % 2 == 0? "Even number" : "Odd number";
        System.out.println(str);
    }
}
