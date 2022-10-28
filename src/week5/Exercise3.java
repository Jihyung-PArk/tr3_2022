package week5;

public class Exercise3 {

    public static PairOfDice dice = new PairOfDice();
    public static final int NUMBER_OF_EXPERIMENTS = 10000;


    public static int rollFor( int N ) {
        int rollCt;      // Number of rolls made.
        rollCt = 0;
        do {
            dice.roll();
            rollCt++;
        } while (dice.getTotal() != N);
        return rollCt;

    }

    public static void main(String[] args) {
        StatCalc statCalc = new StatCalc();

        System.out.println("Total On Dice     Average Number of Rolls     standard deviation of Rolls     maximum number of Rolls");
        System.out.println("-------------     -----------------------     ---------------------------     -----------------------");


        for ( int dice = 2;  dice <= 12;  dice++ ) {

            for (int num = 0; num < NUMBER_OF_EXPERIMENTS; num++) {
                statCalc.enter(rollFor(dice));
            }

            System.out.printf("%6d", dice);
            System.out.printf("%18.3f", statCalc.getMean());
            System.out.printf("%19.3f", statCalc.getStandardDeviation());
            System.out.printf("%14.3f", statCalc.getMax());
            System.out.println();
        }


        }


}



