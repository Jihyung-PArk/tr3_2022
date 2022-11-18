package Week8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestInvalidInput {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        boolean validInput = false;
        int num = 0;

        while (!validInput){
            try{
                System.out.println("Enter a positive integer: ");
                num = myScanner.nextInt();

                if(num > 0) {
                    validInput = true;
                }
            }catch (InputMismatchException e){
                System.out.println("Error : Not a number");
                //clear input console
                myScanner.nextLine();
            }
        }
    }
}
