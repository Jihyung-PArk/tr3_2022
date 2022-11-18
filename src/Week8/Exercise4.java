package Week8;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        String fx;
        String xVal;
        double x;
        double val;
        Expr expression;


        while (true){
            System.out.println("Enter definition of f(x)");
            System.out.print("f(x) = ");
            fx = myObj.nextLine();

            if(fx.length() == 0){
                break;
            }

            try{
                expression = new Expr(fx);
            }catch (IllegalArgumentException e){
                System.out.println("Error! : " + e.getMessage());
                continue;
            }

            System.out.println("Enter x value");
            System.out.print(" x = ");
            xVal = myObj.nextLine();

            if(xVal.length() == 0){
                break;
            }

            try{
                x = Double.parseDouble(xVal);
            }catch (NumberFormatException e){
                System.out.println("Error! : " + e.getMessage());
                continue;
            }
            val = expression.value(x);
            if (Double.isNaN(val)){
                System.out.println("f(" + x + ") is not defined.");

            }else {
                System.out.println("f(" + x + ") = " + val);

            }

        }
    }
}
