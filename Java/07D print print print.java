class Main
{
    private static final Object lock = new Object();
    private static int turn = 1;

    public static void main(String[] args)
    {
        Thread t1 = new Thread(() ->
			{
				for (int i = 0 ; i < 5; i++)
					System.out.println(i);
			}
		);
		Thread t2 = new Thread(() ->
			{
				for (char ch = 'A'; ch <= 'E'; ch++)
					System.out.println(ch);
			}
		);
		Thread t3 = new Thread(() ->
			{
				char[] ary = {'!', '@', '#', '$', '%'};
				for (char i : ary)
					System.out.println(i);
			}
		);

		t1.start();
		t2.start();
		t3.start();
    }
}
