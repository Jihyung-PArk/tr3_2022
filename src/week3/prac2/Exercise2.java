package week3.prac2;

public class Exercise2 {
    public static void main(String[] args) {
        int maxDivisor = 1;
        int max = 1;
        int num;

        for(num = 2; num <= 1000; num ++){
            int divisor;
            int count = 0;

            for(divisor = 1; divisor <= num; divisor ++){
                if(num % divisor == 0){
                    count ++;
                }
            }
            if(maxDivisor < count){
                maxDivisor = count;
                max = num;
            }
        }

        System.out.println(max + " has largest number of divisors.");
        System.out.println(max + " has " + maxDivisor + " much divisors.");
    }
}
