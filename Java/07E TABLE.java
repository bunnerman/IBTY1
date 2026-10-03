class Maine
{
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new TablePrinter(2));
		Thread t2 = new Thread(new TablePrinter(5));
		Thread t3 = new Thread(new TablePrinter(9));

		t1.start();
		t2.start();
		t3.start();
	}
}
class TablePrinter implements Runnable
{
    private static final Object lock = new Object();
    private final int number;

    public TablePrinter(int number)
    {
        this.number = number;
    }

    @Override
    public void run()
    {
        synchronized (lock)
        {
            for (int i = 1; i <= 10; i++)
            {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
            System.out.println();
        }
    }
}
