import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        System.out.print("Enter integer: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		checkA obj = new checkA();

		try {
			obj.checkAge(n);
		}
		catch (LowAgeException e) {
			System.out.print("You are legally a Minor");
		}
    }
}

class LowAgeException extends RuntimeException
{
	public LowAgeException() {
		super();
	}
	public LowAgeException(String msg) {
		super(msg);
	}
}

class checkA {
	public void checkAge(int n) {
		if (n >= 18)
			System.out.print("You are legally an Adult");
		else
			throw new LowAgeException("Error: Below 18");
	}
}
