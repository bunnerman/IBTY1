import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        int[] ary = {8, 2, 4, 1, 3, 6, 4, 0, 2, 7, 4, 2, 5};
		System.out.print("Enter index to access for dividend and divisor: ");
		try
		{
			Scanner sc = new Scanner(System.in);
			int a  = sc.nextInt(); int b = sc.nextInt();
			int quo = ary[a] / ary[b];
			System.out.println("Quotient is " + quo);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.print("Out of bounds");
		}
		catch (ArithmeticException e2)
		{
			System.out.print("Undefined, divisor is 0");
		}
    }
}
