import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
		Predicate<Integer> varB = (Integer num) -> (num % 2 != 0);
		if (varB.test(7))
            System.out.println("Odd");
        else
            System.out.println("Even");
    }
}
