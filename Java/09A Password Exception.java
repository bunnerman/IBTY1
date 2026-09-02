import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        System.out.print("Enter password: ");
		Scanner sc = new Scanner(System.in);
		String st = sc.next();

		CheckP obj = new CheckP();


		try {
			obj.checkPwd(st);
		}
		catch (AuthenException e) {
			System.out.print("Exception Caught");
		}
    }
}

class AuthenException extends Exception
{
	public AuthenException() {
		super();
	}
	public AuthenException(String msg) {
		super(msg);
	}
}

class CheckP {
	public void checkPwd(String str) throws AuthenException {
		String pswd = "very_Secure_Password";
		if (str.equals(pswd))
			System.out.println("Correct Password");
		else
			throw new AuthenException("Auth Failure!");
	}
}
