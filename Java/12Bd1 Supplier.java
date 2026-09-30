import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
		Supplier<Double> varD = () -> {return 2.718281828;};
		System.out.println("Euler's Number is " + varD.get());
    }
}
