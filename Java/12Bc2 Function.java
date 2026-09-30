import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
		Function<Double, Integer> varG = (Double deci) -> (deci.intValue());

		System.out.print("Value with decimal part removed is " + varG.apply(6.767));
    }
}
