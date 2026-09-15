import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
       	System.out.print("Enter student marks: ");
		Scanner sc = new Scanner(System.in);
		float n = sc.nextFloat();
		CheckM obj = new CheckM();

		try {
			obj.checkMarks(n);
		}
		catch (InvalidMarksException e) {
			System.out.println("Exception caught, student has invalid marks out of 0 and 100 bounds");
		}
    }
}

class InvalidMarksException extends RuntimeException
{
	public InvalidMarksException() {
		super();
	}
	public InvalidMarksException(String msg) {
		super(msg);
	}	
}

class CheckM
{
	void checkMarks(float n) // no throws required for runtime excep
	{
		if (n >= 0 && n <= 100)
			System.out.print("Student has valid marks");
		else
			throw new InvalidMarksException("EXCEPTION: STUDENT MARKS INVALID");
	}
}
