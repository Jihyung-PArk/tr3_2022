package week3.prac2;

public class Question14 {
    public static void main(String[] args) {

        int[] number = {1, 4, 6, 123, 42, 12, 56, 42, 54};

        int count = 0;

        int i;

        for (i = 0; i< number.length; i++) {
            if(number[i] == 42){
                count ++;
            }
        }

        System.out.println("Total " + count + " in the array.");
    }
}
