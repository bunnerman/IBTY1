import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        System.out.print("Enter integer: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		CheckN obj = new CheckN();


		try {
			obj.checkNum(n);
		}
		catch (BadNumException e) {
			System.out.print("Exception Caught");
		}
    }
}

class BadNumException extends Exception
{
	public BadNumException() {
		super();
	}
	public BadNumException(String msg) {
		super(msg);
	}
}

class CheckN {
	public void checkNum(int n) throws BadNumException {
		if (n % 2 == 0)
			System.out.print("Number is even");
		else
			throw new BadNumException("Error: Odd Number");
	}
}
