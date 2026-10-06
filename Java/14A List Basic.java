import java.util.ArrayList;
import java.util.List;

class Maine
{
	public static void main(String[] args)
	{
		List<String> obj = new ArrayList<>();

		obj.add("Alpha");
		obj.add("Bravo");
		obj.add(1, "Charlie");

		if (obj.contains("Bravo"))
			System.out.println("Contains Bravo");
		else
			System.out.println("No");

		System.out.println("Index of Charlie is: " + obj.indexOf("Charlie"));

		obj.remove("Alpha");
		obj.remove(0);

		System.out.println(obj); // only bravo remains
	}
}
