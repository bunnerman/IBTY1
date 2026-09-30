import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
		Supplier<String> varH = () -> {
			return "Hello Experiment XII";
		};
		System.out.println(varH.get());
    }
}
