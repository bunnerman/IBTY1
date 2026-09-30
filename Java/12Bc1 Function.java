import java.util.Scanner;
import java.util.function.*;

class Maine
{
    public static void main(String[] args) {
		Function<Float, Float> varC = (Float l) -> {
            float vol = l * l * l;
            return vol;
        };
		System.out.println("Volume of cube is: " + varC.apply(6.5f));
    }
}
