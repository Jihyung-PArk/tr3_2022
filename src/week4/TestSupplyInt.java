package week4;

import textio.TextIO;

public class TestSupplyInt {
    public static void main(String[] args) {

        SupplyInt function;

        function = () -> (int)(1 + (Math.random() * 6 ));


        for (int i = 0; i < 10; i ++){
            System.out.println(function.get());
        }

        function = () -> {
            TextIO.put("Enter your integer : ");
            return TextIO.getInt();
        };

        int anInt = function.get();
        System.out.println(anInt);

    }
}
