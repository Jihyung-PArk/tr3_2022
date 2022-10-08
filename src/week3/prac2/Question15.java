package week3.prac2;

public class Question15 {
    public static void main(String[] args) {

        double[] raceTimes = {50, 1, 4, 6, 123, 42, 12, 56, 42, 54};

        double max = raceTimes[0];
        double min = raceTimes[0];

        int i;

        for(i=1; i<raceTimes.length; i++){
            if(raceTimes[i] > max){
                max = raceTimes[i];
            }
            if(raceTimes[i] < min){
                min = raceTimes[i];
            }
        }

        double range = max - min;

        System.out.println("Range of race time is " + range);
    }
}
