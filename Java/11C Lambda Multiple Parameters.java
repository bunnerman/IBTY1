import java.util.Scanner;

class Maine
{
	public static void main(String[] args) 
	{
		Test obj = (l, b, h) ->
		{
			int vol = l * b * h;
			return vol;
		};
		System.out.print("Enter length, breadth, height: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println("Volume of Rectangle is " + obj.displayVol(a, b, c));
	}
}

interface Test
{
	int displayVol(int x, int y, int z);
}
