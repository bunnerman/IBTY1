import java.util.ArrayList;
import java.util.List;

class Maine
{
	public static void main(String[] args)
	{
		List<String> studNames = new ArrayList<>();

		String[] studList = {"John", "William", "David", "Eli", "Adam", "Madison", "Arnold", "Peter", "Evelyn"};

		for (int i = 0; i < studList.length; i++)
			studNames.addLast(studList[i]);

		System.out.print(studNames);
	}
}
