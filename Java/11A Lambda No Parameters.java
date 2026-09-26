import java.util.Scanner;

class Maine
{
	public static void main(String[] args) 
	{
		Test a = () ->
		{
			System.out.print("Hello");
		};
		a.display();
	}
}

interface Test
{
	void display();
}
