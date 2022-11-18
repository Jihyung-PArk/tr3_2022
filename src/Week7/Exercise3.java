package Week7;

import java.util.Arrays;

public class Exercise3 {
    final static int SIZE = 10000;

    public static void main(String[] args) {

        int[] randomNum;
        int[] randomNumCopy;
        String[] randomString;
        String[] randomStringCopy;
        long start;
        long end;

        randomNum = randomNums(SIZE);
        randomString = randomStr(SIZE);
        randomNumCopy = Arrays.copyOf(randomNum, SIZE);
        randomStringCopy = Arrays.copyOf(randomString, SIZE);


        start = System.nanoTime();
        strSorts(randomString);
        end = System.nanoTime();
        System.out.printf("It took %1.6g seconds to selectSort a total of %d elements.%n", (end - start) / 1e9, SIZE);

        start = System.nanoTime();
        Arrays.sort(randomStringCopy);
        end = System.nanoTime();
        System.out.printf("It took %1.6g seconds to selectSort a total of %d elements.%n", (end - start) / 1e9, SIZE);

        start = System.nanoTime();
        numSorts(randomNum);
        end = System.nanoTime();
        System.out.printf("It took %1.6g seconds to selectSort a total of %d elements.%n", (end - start) / 1e9, SIZE);

        start = System.nanoTime();
        Arrays.sort(randomNumCopy);
        end = System.nanoTime();
        System.out.printf("It took %1.6g seconds to selectSort a total of %d elements.%n", (end - start) / 1e9, SIZE);
    }

    private static void numSorts(int[] randomNum) {
        for (int lastPlace = randomNum.length-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;

            for (int j = 1; j <= lastPlace; j++) {
                if (randomNum[j] > randomNum[maxLoc]) {

                    maxLoc = j;
                }
            }

            int temp = randomNum[maxLoc];
            randomNum[maxLoc] = randomNum[lastPlace];
            randomNum[lastPlace] = temp;

        }

    }

    private static void strSorts(String[] randomString) {
        for (int lastPlace = randomString.length-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;

            for (int j = 1; j <= lastPlace; j++) {
                if (randomString[j].compareTo(randomString[maxLoc])>0) {
                    maxLoc = j;
                }
            }

            String temp = randomString[maxLoc];  // Swap largest item with A[lastPlace].
            randomString[maxLoc] = randomString[lastPlace];
            randomString[lastPlace] = temp;
        }
    }

    private static String randomString() {
        int length = 5 + (int)(21*Math.random());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = (char)('A' + (int)(26*Math.random())); // a random letter
            str.append(ch);
        }
        return str.toString();
    }

    private static String[] randomStr(int num) {
        String[] strs = new String[num];
        for(int i = 0; i < num; i++){
            strs[i] = (String) randomString();
        }
        return strs;
    }

    private static int[] randomNums(int num) {
        int[] numbers = new int[num];
        for(int i = 0; i < num; i++){
            numbers[i] = (int) Math.random()*10;
        }
        return numbers;
    }
}
