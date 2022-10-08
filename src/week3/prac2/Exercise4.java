package week3.prac2;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);


        System.out.print("Enter any sentence : ");

        String sentence = myObj.nextLine();

        for (int i = 0; i < sentence.length(); i++){
            char letter = sentence.charAt(i);

            if(Character.isLetter(letter)) {
                System.out.print(letter);
            } else if(!Character.isLetter(sentence.charAt(i - 1))) {

            }else{
                System.out.println();
            }
        }


    }
}
