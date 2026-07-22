import java.util.Scanner;

class Example 
{
    public static void main(String[] args) 
    {
		System.out.println("Enter 3 numbers-");
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
		if (a > b)
		{
			if (a > c)
				System.out.println("A is the greatest");
			else
				System.out.println("C is the greatest");
		}
		else
		{
			if (b > c)
				System.out.println("B is the greatest");
			else
				System.out.println("C is the greatest");
		}
		scan.close();
    }
}
