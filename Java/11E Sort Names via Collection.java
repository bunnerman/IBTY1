import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main
{
	public static void main(String[] args)
	{
		List<String> studentNames = new ArrayList<>(Arrays.asList("John", "William", "David", "Eli", "Adam", "Madison", "Arnold", "Peter", "Evelyn"));
		Collections.sort(studentNames);
		System.out.print(studentNames);
	}
}
