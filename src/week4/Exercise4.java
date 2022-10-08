package week4;

public class Exercise4 {


    public static int pairDice (int num){

        if (num < 2 || num > 12) {
            var message = String.format("Out of range");
            throw new IllegalArgumentException(message);
        }

        int count = 0;
        int totalDice = 1;

        while (totalDice != num){
            int dice1 = (int) (6*Math.random() + 1);
            int dice2 = (int) (6*Math.random() + 1);
            totalDice = dice1 + dice2;

            count ++;
        }

        return count;
    }


    public static double averageNum ( int numOfRoll) {

        int total = 0;

        for(int i = 0; i < 10000; i++){
            int roll = pairDice(numOfRoll);
            total += roll;
        }

        return ((double) total ) / 10000;

    }

    public static void main(String[] args) {

        System.out.println("Total On Dice     Average Number of Rolls");
        System.out.println("-------------     -----------------------");

        for (int i = 2; i < 13; i++) {
            double average = averageNum(i);
            System.out.printf("%10d%22.4f\n", i, average);
        }
    }
}
