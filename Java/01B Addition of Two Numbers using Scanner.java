import java.util.Scanner;

class Example 
{
    public static void main(String[] args) 
    {
		System.out.println("Enter 2 numbers-");
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int sum = a + b;
        System.out.println("Sum is " + sum);
		scan.close();
    }
}
