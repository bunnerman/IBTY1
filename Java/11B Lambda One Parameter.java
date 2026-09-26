import java.util.Scanner;

class Maine
{
	public static void main(String[] args) 
	{
		Test a = (int n) ->
		{
			int sq = n * n;
			System.out.println("Square is " + sq);
		};
		a.displaySq(3);
		a.displaySq(4);
	}
}

interface Test
{
	void displaySq(int n);
}
