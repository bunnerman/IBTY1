import java.util.Scanner;

class Maine
{
	public static void main(String[] args) 
	{
		System.out.print("Enter a binary mathematical expression: ");
		Scanner sc = new Scanner(System.in);

		float x = sc.nextFloat();
		char oprtr = sc.next().charAt(0);
		float y = sc.nextFloat();

		Calculator summ = (a, b) -> a + b;
		Calculator diff = (a, b) -> a - b;
		Calculator prod = (a, b) -> a * b;
		Calculator quot = (a, b) -> a / b;

		switch(oprtr)
		{
			case '+':
				System.out.print(summ.operation(x, y));
				break;
			case '-':
				System.out.print(summ.operation(x, y));
				break;
			case '*':
				System.out.print(summ.operation(x, y));
				break;
			case '/':
				System.out.print(summ.operation(x, y));
				break;
		}
	}
}

interface Calculator
{
	float operation(float a, float b);
}
