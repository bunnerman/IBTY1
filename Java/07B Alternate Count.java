class Main {
    static int n = 1;

    public static void main(String[] args) {
        new Thread(() -> 
		{
            while (n <= 20) 
			{
                synchronized (Main.class) 
				{
                    if (n % 2 == 1) 
					{
                        System.out.print(n++ + " ");
                        Main.class.notify();
                    } else 
					{
                        try { Main.class.wait(); } catch (Exception e) {}
                    }
                }
            }
        }).start();

        new Thread(() -> 
		{
            while (n <= 20) 
			{
                synchronized (Main.class) 
				{
                    if (n % 2 == 0)
					{
                        System.out.print(n++ + " ");
                        Main.class.notify();
                    } 
					else 
					{
                        try { Main.class.wait(); } catch (Exception e) {}
                    }
                }
            }
        }).start();
    }
}
