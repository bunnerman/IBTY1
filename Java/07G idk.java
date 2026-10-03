class Maine
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> 
        {
            for (int i = 1; i <= 5; i++)
            {
                System.out.println("Worker Thread: " + i);
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {}
            }
        });

        System.out.println("Main thread starting Worker Thread...");
        t1.start();

        try
        {
            t1.join();
        }
        catch (InterruptedException e) {}

        System.out.println("Worker Thread finished. Main thread resuming execution.");
    }
}
