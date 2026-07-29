import java.util.Scanner;

class Example
{
	public static void main(String[] args) 
	{
		System.out.println("Enter string: ");
		String st;
		Scanner sc = new Scanner(System.in);
		st = sc.nextLine();
		int len = st.length();
		int vowelCount = 0;
		for (int i = 0; i < len; i++)
		{
			char ch = st.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				vowelCount++;
		}
		System.out.println(vowelCount + " vowels are present");
	}	
} 
