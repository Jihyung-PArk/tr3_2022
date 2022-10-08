package week3.prac2;

public class Question9 {
    public static void main(String[] args) {

        int x = 0;
        int y = 0;

        while (x == y ){
            x = (int)(10*Math.random() + 1);
            y = (int)(10*Math.random() + 1);
        }

        System.out.println(x + " " + y);


    }
}
