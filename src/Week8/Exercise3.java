package Week8;

import textio.TextIO;

public class Exercise3 {


    public static void main(String[] args) {

        int arabic;
        String roman;

        System.out.println("Enter a Roman numeral or Arabic numeral ( 1 to 3999 )");
        System.out.println("Press return when you want to quit.");
        System.out.println("");

        System.out.println("What is your number?");

        while (true){


            while (TextIO.peek() == ' ' || TextIO.peek() == '\t')
                TextIO.getAnyChar();
            if ( TextIO.peek() == '\n' )
                break;

            if ( Character.isDigit(TextIO.peek())){

                arabic = TextIO.getInt();
                try{
                    RomanArabic num = new RomanArabic(arabic);
                    System.out.println(num.convertInt() + " = " + num.convertString());

                }catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                    System.out.println(e.getMessage());
                }

            }else {
                roman = TextIO.getln();

                try{
                    RomanArabic num = new RomanArabic(roman);
                    System.out.println(num.convertString() + " = " + num.convertInt());
                    System.out.printf("In standard form, %s is written $s.$n", roman, num.toString());
                }catch (NumberFormatException e){
                    System.out.println("Invalid input");
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Finish");
    }



}
