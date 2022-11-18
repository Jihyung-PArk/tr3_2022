package Week7;

public class Question9 {

    public static int largest(int [] ints){

        int maxInt;

        maxInt = ints[0];

        for(int i = 0; i < ints.length; i++){
            if (ints[i] > maxInt){
                maxInt = ints[i];
            }
        }

        return maxInt;
    }
}
