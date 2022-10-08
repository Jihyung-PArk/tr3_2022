package week4;



public class Question10 {

    interface Stars {
        String get (String str);
    }

    public static void main(String[] args) {


        Stars star = x -> x + "*";

        String outPut = "";
        System.out.println(outPut);

        for (int i=0; i < 10; i ++){
            outPut = star.get(outPut);
            System.out.println(outPut);


        }


    }
}
