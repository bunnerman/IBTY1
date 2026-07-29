import java.util.Scanner;

public class Example 
{
	public static String reverseString(String st)
	{
		return new StringBuilder(st).reverse().toString();
	}

    public static void main(String[] args) 
	{
		// 1
		String pwd = "kayak";
		System.out.print("Enter string: ");
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		if (st.compareTo(pwd) == 0)
			System.out.println("WELCOME");
		else
			System.out.println("INTRUDER");

		// 2
		String rev = reverseString(st);
		if (st.equals(rev))
			System.out.println("Is Palindrome");
		else
			System.out.println("Not Palindrome");
		
		// 3 - Uses different string
		String st2 = "hello";
		System.out.println(reverseString(st2));

		// 4 & 5
		int len = st.length();
		int vowelCount = 0;
		int charCount = 0;
		for (int i = 0; i < len; i++)
		{
			char ch = st.charAt(i);
			charCount++;
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				vowelCount++;
		}
		System.out.println(vowelCount + " vowels are present");
		System.out.println(charCount + " characters are present");
    }
}
