package week3;

public class test_if {
    public static void main(String[] args) {

        int x = (int) (Math.random() * 100);
        int y;

        if (x < 0) {
            y = 1;
        } else {
            y = 2;
        }

        System.out.println(y);

    }
}

