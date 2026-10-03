// Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.Write a Java program to demonstrate thread priorities.

  class Maine
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> 
        {
            System.out.println("Low");
        });

        Thread t2 = new Thread(() -> 
        {
            System.out.println("Normal");
        });

        Thread t3 = new Thread(() -> 
        {
            System.out.println("High");
        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        System.out.println("t1 priority: " + t1.getPriority());
        System.out.println("t2 priority: " + t2.getPriority());
        System.out.println("t3 priority: " + t3.getPriority());

        t1.start();
        t2.start();
        t3.start();
    }
}
