import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        int[] ary = {8, 2, 4, 1, 3, 7, 544, 7, 2, 5};
		System.out.print("Enter index to access: ");
		try
		{
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			System.out.println("Value is " + ary[n]);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Out of bounds");
		}
		finally
		{
			System.out.print("Access attempt completed");
		}
    }
}
