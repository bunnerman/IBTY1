import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
        // Consumer - prints message
        // Predicate - odd/even
        // Function - returns volume of cube
        // Supplier - returns eulers number
        // FunctionB - returns typecasted int
        // SupplierB - returns a string

        Consumer<String> varA = (String msg) -> {
            System.out.println(msg);
        };
        Predicate<Integer> varB = (Integer num) -> (num % 2 != 0);
        Function<Float, Float> varC = (Float l) -> {
            float vol = l * l * l;
            return vol;
        };
        Supplier<Double> varD = () -> {return 2.718281828;};

        varA.accept("Hello World!");
        if (varB.test(7))
            System.out.println("Odd");
        else
            System.out.println("Even");
        System.out.println("Volume of cube is: " + varC.apply(6.5f));
        System.out.println("Euler's Number is " + varD.get());

        varA.accept("Test String");
        if (varB.test(2))
            System.out.println("Odd");
        else
            System.out.println("Even");


        Function<Double, Integer> varC2 = (Double deci) ->
        {
            return deci.intValue();
        };

        Supplier<String> varD2 = () -> {
            return "Example D";
        };

        System.out.println("Typecasted Version: " + varC2.apply(6.5));
        System.out.println(varD2.get());

    }
}
