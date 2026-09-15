import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
       	System.out.print("Enter 2 integers: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); int b = sc.nextInt();

		DivisionClass obj = new DivisionClass();
		obj.div(a, b);
    }
}

class DivisionClass {
	void div(int a, int b) throws ArithmeticException {
		try {
			int n = a / b;
			System.out.print("Quotient is " + n);
		}
		catch (ArithmeticException e) {
			System.out.println("Exception thrown, undefined, 0 is divisor");
		}
	}
}
