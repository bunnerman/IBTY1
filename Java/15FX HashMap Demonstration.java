import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Maine
{
	public static void main(String[] args) 
	{
		Map<Integer, String> obj = new HashMap<>();

		obj.put(1,"Alpha");
		obj.put(2, "Beta");
		obj.put(3, "Gamma");
		System.out.println(obj);

		obj.put(2, "Bravo");

		System.out.println(obj);

		if (obj.containsKey(4)) System.out.print("Contains Delta");
		else obj.put(4, "Delta");

		
		if (obj.containsValue("Delta")) System.out.println("Insertion of Delta was successful 2 commands ago");
		else System.out.println("Delta not Present");
		
		if (obj.remove(2, "Bravo")) System.out.println("2:Bravo removed");
		else System.out.println("Bravo not present at Key 2"); 

		System.out.println(obj.get(2)); // nothing present at 2 now
		System.out.println(obj.get(3)); // Gamma
	}
}
