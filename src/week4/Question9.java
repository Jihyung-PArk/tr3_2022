package week4;

import java.util.Scanner;

public class Question9 {

    public static void stars(int num){

        for(int i = 0; i < num; i++ ){
            System.out.print("*");
        }
    }

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter the number of stars : ");
        int numOfStars = myObj.nextInt();

        stars(numOfStars);
    }
}
