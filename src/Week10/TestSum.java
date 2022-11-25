package Week10;

public class TestSum {
    public static void main(String[] args) {

        System.out.println(sumNaturalNum(5));
    }

    static long sumNaturalNum(long n){

        //base case
        if ( n == 1){
            return 1;

        // general case
        }else{
            return n + sumNaturalNum(n-1);
        }
    }
}
