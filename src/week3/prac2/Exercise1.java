package week3.prac2;

public class Exercise1 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int count = 0;

        do{
            x = (int)(6*Math.random() + 1);
            y = (int)(6*Math.random() + 1);

            count ++;
        }while (x != 1 || y != 1);

        System.out.println("Total " + count + "times roll a pair");
    }
}
