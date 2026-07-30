import java.util.Scanner;

public class Example 
{
    public static void main(String[] args) 
	{
		System.out.print("Enter integer X: ");
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		System.out.print("Enter integer Y: ");
		String y = sc.nextLine();

		Integer wrprObj =  Integer.valueOf(x);
		int m = wrprObj.intValue();
		wrprObj = Integer.valueOf(y);
		int n = wrprObj.intValue();

		int sum = m + n;

		System.out.print("Sum is " + sum);
    }
}
