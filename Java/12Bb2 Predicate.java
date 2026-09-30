import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
		// If 5 characters long return true
		Predicate<String> varF = (String s) -> (s.length() == 5);
		if (varF.test("Hello"))
			System.out.print("5 letters");
		else
			System.out.print("Not 5 letters");
    }
}
