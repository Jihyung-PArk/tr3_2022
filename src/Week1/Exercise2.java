package Week1;

public class Exercise2 {
    public static void main(String[] args) {
        int die1 = (int)(Math.random() * 6) + 1;
        int die2 = (int)(Math.random() * 6) + 1;
        int roll = die1 + die2;

        System.out.println("The first die comes up " + die1);
        System.out.println("THe second die comes up " + die2);
        System.out.println("Your total roll is " + roll);

    }
}
