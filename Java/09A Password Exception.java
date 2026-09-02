import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        System.out.print("Enter pwd: ");
		Scanner sc = new Scanner(System.in);
		String st = sc.next();

		CheckP obj = new CheckP();
		obj.checkPwd(st);
    }
}

class pwdException extends RuntimeException
{
	public pwdException() {
		super();
	}
	public pwdException(String msg) {
		super(msg);
	}
}

class CheckP {
	public void checkPwd(String str) throws pwdException {
		String pswd = "very_Secure_Password";
		if (str.equals(pswd))
			System.out.println("Correct Password");
		else
			throw new pwdException("Auth Failure!");
	}
}
