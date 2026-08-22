import java.util.Scanner;
import bank.Account;

class Maine
{
    public static void main(String[] args) 
    {
        System.out.println("\n--JACOB--\n");
        Account jacob = new Account();
        jacob.checkBalance();
        jacob.deposit(5000);
        jacob.withdraw(400);
        jacob.checkBalance();
        
        System.out.println("\n--ZACK--\n");
        Account zack = new Account();
        zack.withdraw(300);
        zack.deposit(40);
        zack.deposit(700000);
        zack.withdraw(5000);
        zack.checkBalance();
    }
}
