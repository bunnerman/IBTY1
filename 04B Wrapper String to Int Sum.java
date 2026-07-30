import java.util.Scanner;

public class Example 
{
    public static void main(String[] args) 
	{
		System.out.print("Enter 2 integers X Y: ");
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		String y = sc.next();

		Integer wrprObj =  Integer.valueOf(x);
		int m = wrprObj.intValue();
		wrprObj = Integer.valueOf(y);
		int n = wrprObj.intValue();

		int sum = m + n;

		System.out.print("Sum is " + sum);
    }
}
