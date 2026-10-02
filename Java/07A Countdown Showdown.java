import java.util.Scanner;

class Maine
{
	public static void main(String[] args)
	{
		Thread t1 = new Thread(() ->
			{
				for (int i = 0; i <= 10; i++)
				{
					System.out.print(i + " ");
					if (i == 2)
						Thread.yield();
				}
			}
		);
		Thread t2 = new Thread(() -> 
			{
				for (int i = 10; i>= 1; i--)
					System.out.print(i + " ");
			}
		);

		t1.start();
		t2.start();
	}
}
