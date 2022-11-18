package Week7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {




    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        int repeatTime;
        int scale;

        try
        {
            System.out.println("Choose how many random integer do you want? ");
            repeatTime = myObj.nextInt();
            System.out.println("Choose scale of randon integer do you want?");
            scale = myObj.nextInt();
            System.out.println(randomNumArray(repeatTime,scale));
        }
        catch (InputMismatchException e)
        {
            System.out.println("Not a number! Try again");

        }
    }

    public static ArrayList<Integer> randomNumArray (int repeatTime, int scale) throws IllegalArgumentException{

        if (repeatTime > scale){
            throw new IllegalArgumentException("Out of range!");
        }

        ArrayList<Integer> arrayNum = new ArrayList<Integer>();

        while (arrayNum.size() < repeatTime){

            int randomNum = (int) (Math.random()*scale) + 1;

            arrayNum.add(randomNum);
        }
        return arrayNum;
    }
}
