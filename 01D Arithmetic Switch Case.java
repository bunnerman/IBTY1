import java.util.Scanner;

class Example 
{
    public static void main(String[] args) 
    {
		System.out.println("Enter 2 numbers and any of the following: + - * /");
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
		int op = sc.next().charAt(0);
		float result = 0;
		switch(op)
		{
			case '+':
				result = a + b;
				break;
			case '-':
				result = a - b;
				break;
			case '*':
				result = a * b;
				break;
			case '/':
				result = (float) a / b;
				break;
			default:
				System.out.println("Error");
				sc.close();
				return;
		}

		System.out.println("Result is " + result);
		sc.close();       
	}
}
