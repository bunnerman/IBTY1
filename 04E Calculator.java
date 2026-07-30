import java.util.Scanner;

class Example
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary arithmetic operation using + - * / or %: ");
        String x = sc.next();
        String oprtr = sc.next();
        String y = sc.next();

        Integer wrprObj = Integer.valueOf(x);
        int a = wrprObj.intValue();
        wrprObj = Integer.valueOf(y);
        int b = wrprObj.intValue();
        int res = 0;

        switch(oprtr)
        {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
            case "%":
                res = a % b;
                break;
        }
        String resXprsn = x + " " + oprtr + " " + y + " = " + res;
        System.out.println(resXprsn);
    }
}