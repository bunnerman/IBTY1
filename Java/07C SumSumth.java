class Main 
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> 
        {
            try
            {
                for (int i = 10; i <= 20; i++)
                {
                    System.out.println("Thread 1: " + i);
                    if (i == 11)
                        Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {}
        });

        Thread t2 = new Thread(() -> 
        {
            for (int i = 20; i >= 1; i--)
            {
                System.out.println("Thread 2: " + i);
            }
        });

        t1.start();
        t2.start();
    }
}
