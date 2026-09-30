import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
		Consumer<Integer> varE = (Integer i) -> {
			System.out.print("Square is " + i * i);
		};
		varE.accept(7);
    }
}
