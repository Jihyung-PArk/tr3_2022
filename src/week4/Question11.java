package week4;

import java.util.Scanner;

public class Question11 {

    static int countChars ( String str, char chr){

        int count = 0;

        for (int i = 0; i < str.length(); i ++) {

            if ((char) str.charAt(i) == chr){

                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        System.out.println("Check your character in string.");
        System.out.print("Enter your String : ");
        String strInput = myObj.nextLine();
        System.out.print("Enter character : ");
        char chaInput = myObj.next().charAt(0);

        System.out.println(countChars(strInput, chaInput) + " (" + chaInput + ") Chracter in the" + strInput);




    }
}
