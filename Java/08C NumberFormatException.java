import java.util.Scanner;

class Maine
{
    public static void main(String[] args) 
    {
        System.out.print("Enter number: ");
        Scanner sc = new Scanner(System.in);
        try
        {
            String st = sc.next();
            int n = Integer.parseInt(st);
            System.out.print("Converted to integer -> " + n);
        }
        catch (NumberFormatException e)
        {
            System.out.print("Unable to be converted");
        }
    }
}
