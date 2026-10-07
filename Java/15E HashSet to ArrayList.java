import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;


class Maine
{
	public static void main(String[] args)
	{
		Set<Integer> objS = new HashSet<>(Set.of(1, 2, 3, 4, 6, 7, 8));
		objS.add(5);
		objS.add(49);

		List<Integer> objA = new ArrayList<>(objS);

		System.out.println("HashSet: " + objS);
		System.out.println("ArrayList: " + objA);
	}
}
