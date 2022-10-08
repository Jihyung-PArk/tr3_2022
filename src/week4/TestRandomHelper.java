package week4;

import textio.TextIO;

public class TestRandomHelper {
    public static void main(String[] args) {

        TextIO.put("Enter min : ");
        int min = TextIO.getlnInt();

        TextIO.put("Enter max : ");
        int max = TextIO.getlnInt();

        try{
            int secretNum = RandomHelper.nextInt(min, max);

        }
        catch(IllegalArgumentException e){
            System.out.println("Error : " + e.getLocalizedMessage());
        }
    }
}
