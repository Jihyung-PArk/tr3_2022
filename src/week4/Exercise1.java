package week4;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter your sentence : ");
        String sentence = myObj.nextLine();

        System.out.println("Capitalizing your sentence");

        Capitalize(sentence);

    }

    static void Capitalize( String sentence){

        System.out.print(Character.toUpperCase(sentence.charAt(0)));

        for(int i = 1; i < sentence.length(); i++){

            char letter = sentence.charAt(i);


            if(Character.isLetter(letter) && !Character.isLetter(sentence.charAt(i - 1))){
                System.out.print(Character.toUpperCase(letter));
            }else{
                System.out.print(letter);
            }


        }
    }
}
