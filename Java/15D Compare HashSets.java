import java.util.HashSet;
import java.util.Set;

class Maine
{
	public static void main(String[] args)
	{
		Set<Integer> objA = new HashSet<>(Set.of(1, 2, 3, 4, 6, 7));
		Set<Integer> objB = new HashSet<>(Set.of(1, 3, 5, 6, 7, 8));

		Set<Integer> objC = new HashSet<>(objA);
		objC.retainAll(objB);		

		System.out.print("Common Elements are:\n" + objC);
	}
}
