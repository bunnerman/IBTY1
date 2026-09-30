import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
        Consumer<String> varA = (String msg) -> {
            System.out.println(msg);
        };
        varA.accept("Hello World!");
    }
}
