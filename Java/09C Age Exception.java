import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        System.out.print("Enter integer: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		CheckA obj = new CheckA();
		
		obj.checkAge(n);
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

class CheckA {
	public void checkAge(int n) {
		if (n >= 18)
			System.out.print("Adult");
		else
			throw new LowAgeException("Error: Minor");
	}
}
