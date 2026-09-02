import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        System.out.print("Enter integer: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		CheckN obj = new CheckN();
		obj.checkNum(n);
    }
}

class OddNumException extends RuntimeException
{
	public OddNumException() {
		super();
	}
	public OddNumException(String msg) {
		super(msg);
	}
}

class CheckN {
	public void checkNum(int n) throws OddNumException {
		if (n % 2 == 0)
			System.out.print("Number is even");
		else
			throw new OddNumException("Error: Odd Number");
	}
}
