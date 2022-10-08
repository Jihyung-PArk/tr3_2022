package week4;

public class TestFunctionR2R {
    public static void main(String[] args) {

        FunctionR2R function;

        function = x -> x * x;
        System.out.println(function.valueAt(100));

        function = x -> Math.sqrt(x);
        System.out.println(function.valueAt(100));
    }
}
