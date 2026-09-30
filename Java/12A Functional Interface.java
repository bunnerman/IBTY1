import java.util.Scanner;
import java.util.function.*;

class Maine
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter radius of circle: ");
		double n = sc.nextDouble();

		Test areaCircle = (r) ->
		{
			System.out.println("Area of Circle is " + (3.14159 * r * r));
		};
		Test circumferenceCircle = (r) ->
		{
			System.out.println("Circumference of Circle is " + (3.14159 * 2 * r));
		};

		areaCircle.lamb(n);
		circumferenceCircle.lamb(n);
	}
}

@FunctionalInterface 
interface Test
{
	void lamb(double r);
}
