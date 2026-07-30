import java.util.Scanner;

public class Example 
{
    public static void main(String[] args) 
	{
		System.out.print("Enter integer: ");
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();

		Integer wrprObj =  Integer.valueOf(st);
		int primVal = wrprObj.intValue();

		
		System.out.println(st + " " + wrprObj + " " + primVal);
		if (primVal % 2 == 0)
			System.out.print("Even");
		else
			System.out.print("Odd");
    }
}
