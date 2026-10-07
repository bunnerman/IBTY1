import java.util.HashSet;
import java.util.Set;

class Maine
{
	public static void main(String[] args)
	{
		Set<String> empNames = new HashSet<>();

		String[] empList = {"John", "William", "David", "Eli", "Adam", "Madison", "Arnold", "Peter", "Evelyn"};

		for (int i = 0; i < empList.length; i++)
			empNames.add(empList[i]);	

		System.out.print(empNames);
	}
}
