import java.util.Scanner;

class Example 
{
    public static void main(String[] args) 
    {
		System.out.println("Enter lower and upper bounds (both exclusive)- ");
		Scanner sc = new Scanner(System.in);
		int lwr = sc.nextInt();
		int upr = sc.nextInt();
		int sum = 0;
		for (int i = lwr + 1; i < upr; i++)
		{
			sum += i;
		}
		System.out.println("Sum is " + sum);
	}
}
