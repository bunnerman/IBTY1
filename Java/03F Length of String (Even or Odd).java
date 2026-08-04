import java.util.Scanner;

class Example
{
	public static void main(String[] args) 
	{
		System.out.println("Enter string: ");
		String st;
		Scanner sc = new Scanner(System.in);
		st = sc.nextLine();
		String r;
		if (st.length() % 2 == 1)
			r = "Odd";
		else
			r = "Even";
		System.out.println("Length of given string is " + r);
	}	
} 
