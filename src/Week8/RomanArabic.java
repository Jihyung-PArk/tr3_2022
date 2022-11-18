package Week8;

public class RomanArabic {

    private final int num;

    public RomanArabic (int arabic){
        if (arabic < 1){
            throw new NumberFormatException(" Arabic number must be positive.");
        } else if (arabic >= 4000) {
            throw new NumberFormatException("Arabic number must be smaller than 4000.");
        }
        num = arabic;
    }

    public RomanArabic (String roman){
        int arabic = 0;

        if(roman.length()==0){
            throw new NumberFormatException("Roman number can not be empty.");
        }

        roman = roman.toUpperCase();

        for(int i = 0; i <roman.length(); i++){
            char letter = roman.charAt(i);
            int numArabic = letterToArabic(letter);

            if(i == roman.length()-1){
                arabic += numArabic;
            }else {
                int nextNumArabic = letterToArabic(roman.charAt(i+1));
                if(nextNumArabic > numArabic){
                    arabic += (nextNumArabic - numArabic);
                    i++;
                }else {
                    arabic += numArabic;
                }
            }
        }
        if(arabic >= 4000){
            throw new NumberFormatException("Roman number must be smaller than 4000.");
        }

        num = arabic;
    }

    private int letterToArabic(char letter) {
        return switch (letter) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new NumberFormatException(
                    "Illegal character in Roman numeral : " + letter);
        };
    }

    private static int [] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static String [] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String convertString(){
        String roman = "";
        int romanNum = num;

        for(int i = 0; i < numbers.length; i++){
            while (romanNum >= numbers[i]){
                roman += (letters[i]);
                romanNum -= numbers[i];
            }
        }
        return roman;
    }

    public int convertInt(){
        return num;
    }
}
