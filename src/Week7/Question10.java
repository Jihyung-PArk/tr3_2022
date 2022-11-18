package Week7;

public class Question10 {

    public static void main(String[] args) {

        int[][] temps = new int[100][365];
        int totalTemps = 0;
        double avgTemps;

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 365; j++){
                totalTemps += temps[i][j];
            }

            avgTemps = totalTemps / 365.0;
            System.out.println("Averag temperature is " + avgTemps + " (City number : " + i + " )");
        }
    }



}
