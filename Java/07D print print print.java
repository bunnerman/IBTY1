class Main
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() ->
			{
				for (int i = 1 ; i <= 10; i++)
					System.out.print(i);
			}
		);
		Thread t2 = new Thread(() ->
			{
				for (char ch = 'A'; ch <= 'J'; ch++)
					System.out.print(ch);
			}
		);
		Thread t3 = new Thread(() ->
			{
				char[] ary = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')'};
				for (char i : ary)
					System.out.print(i);
			}
		);

		t1.start();
		t2.start();
		t3.start();
    }
}
