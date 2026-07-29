import java.util.Scanner;

public class Example 
{
    public static void main(String[] args) 
	{
		System.out.print("Enter first name: ");
		Scanner sc = new Scanner(System.in);
		String FN = sc.nextLine();
		System.out.print("Enter last name: ");
		String LN = sc.nextLine();
        System.out.println(FN + " " + LN);
    }
}
