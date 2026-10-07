import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class Main
{
	public static void main(String[] args)
	{
		Set<Integer> obj = new HashSet<>();

		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(2); // dupe
		obj.add(3); // dupe
		if (!obj.add(4)) // dupe, returns false
			System.out.println("Returned False");

		System.out.print(obj);
	}
}
