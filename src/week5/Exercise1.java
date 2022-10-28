package week5;

public class Exercise1 {
    public static void main(String[] args) {

        PairOfDice dice = new PairOfDice();
        int num_of_roll = 0;

        do{
            dice.roll();
            System.out.println("Get " + dice);
            num_of_roll ++;
        }while (dice.getTotal() != 2);

        System.out.println(num_of_roll + " times to rolls get 2");

    }



}
