public class Example 
{
    public static void main(String[] args) 
	{
        String st = "hello world";

        StringBuilder sb = new StringBuilder(st);
        sb.setCharAt(4, ' ');

        System.out.println(sb.toString());
    }
}
