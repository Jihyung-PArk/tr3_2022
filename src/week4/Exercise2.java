package week4;

import java.util.Scanner;

public class Exercise2 {


    static int hexadecimal(char hex) {

        switch (hex) {
            case '0' :
                return 0;
            case '1' :
                return 1;
            case '2' :
                return 2;
            case '3' :
                return 3;
            case '4' :
                return 4;
            case '5' :
                return 5;
            case '6' :
                return 6;
            case '7' :
                return 7;
            case '8' :
                return 8;
            case '9' :
                return 9;
            case 'a', 'A' :
                return 10;
            case 'b', 'B' :
                return 11;
            case 'c', 'C' :
                return 12;
            case 'd', 'D' :
                return 13;
            case 'e', 'E' :
                return 14;
            case 'f', 'F' :
                return 15;
            default :
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        long value = 0;

        System.out.print("Enter hexadecimal number : ");
        String hexInput = myObj.nextLine();



        for (int i = 0; i < hexInput.length(); i ++) {
            if( hexadecimal(hexInput.charAt(i)) == -1){
                System.out.println("Your number is not hexadecimal number.");
                return;
            }
            value = value*16 + hexadecimal(hexInput.charAt(i));
        }

        System.out.println(value);
    }
}
