package week4;

public class Question12 {
    public static void main(String[] args) {
        System.out.println(smallest(3,4,5));
        System.out.println(smallest(3,5,4));
        System.out.println(smallest(5,4,3));
        System.out.println(smallest(4,3,5));
        System.out.println(smallest(3,3,3));

    }

    static int smallest(int x, int y, int z){

        /*
        if(x < y && x < z){
            return x;
        } else if (y < x && y < z) {
            return y;
        } else if (z < x && z < y) {
            return z;
        } else if (x == y && x < z) {
           return x;
        } else if (x == z && x < y) {
            return x;
        } else if (y == z && y < x) {
            return y;
        }else{
            return x;
        }
*/

        int smallestNum = x;

        if (smallestNum > y) {
            smallestNum = y;
        }
        
        if (smallestNum > z) {
            smallestNum = z;
        }

        return smallestNum;
    }
}
