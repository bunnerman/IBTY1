import java.util.Scanner;

class Example 
{
    public static void main(String[] args) 
    {
		System.out.println("Enter an integer");
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		int sum = 0;
		int digit;
		String rev = "";
		while (n != 0)
		{
			digit = n % 10;
			rev = rev.concat(Integer.toString(digit));
			sum += digit;
			n /= 10;
		}
		System.out.println("Sum of all digits is " + sum);
		System.out.println("Reversed number is " + rev);
		sc.close();       
	}
}
