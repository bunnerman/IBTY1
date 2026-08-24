import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        try
		{
			System.out.print("Enter dividend and divisor: ");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int b = sc.nextInt();
			int quo = a / b;
			System.out.print("Quotient is " + quo);
		}
		catch (ArithmeticException e)
		{
			System.out.print("Undefined, divisor is 0");
		}
    }
}
