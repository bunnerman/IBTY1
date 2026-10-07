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
		if (!obj.add(1)) // ignored
			System.out.print("1 Already Exists");
		obj.add(3);
		obj.add(4);

		if (obj.contains(4))
			System.out.println("Set contains the number 4");

		obj.remove(1); // defaults to value instead of index

		System.out.print(obj);
	}
}
