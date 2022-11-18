package Week8;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise2 {

    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);


        BigInteger num;
        String input;


        while (true) {
            System.out.println("Enter your starting number : ");
            input = myObj.nextLine();

            if (input.length() == 0) {
                break;
            }

            try{
                num = new BigInteger(input);
                if(num.signum() == 1){
                    threeNSequnce(num);


                }else{
                    System.out.println("Error : It can not be zero or smaller than zero.");
                }
            }catch (NumberFormatException e){
                System.out.println("Error : A legal integer");
            }
        }

    }

    private static void threeNSequnce(BigInteger num) {

        int count = 0;

        System.out.println("3N+1 sequence starting with \" + num + \" is:");

        do {
            System.out.println(num.toString());
            count++;
            if(!num.testBit(0)){
                num = num.divide(TWO);
            }else {
                num = num.multiply(THREE);
                num = num.add(ONE);
            }
        }
        while(!num.equals(ONE));

        System.out.println(num.toString());
        System.out.println("There were " + count + " terms in the sequence.");
    }
}
