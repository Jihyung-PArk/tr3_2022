package week4;

import java.util.Random;

public class RandomHelper {

    public static int nextInt (int min, int max){
        if (min >= max){

            //java 10 has var to declare local variables
            var message = String.format("the range [%d, %d] is invalid", min, max);
            throw new IllegalArgumentException(message);

        }

        Random random = new Random();
        return min + random.nextInt(max-min + 1);
    }
}
