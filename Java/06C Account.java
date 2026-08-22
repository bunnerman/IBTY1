public class Account 
{
        int balance = 0;
        void deposit(int n)
        {
            balance += n;
            System.out.println("Deposit Successful");
        }  
        void withdraw(int n)
        {   
            if (balance < n)
            {
                System.out.println("Too Broke");
                return;
            }
            balance -= n;
            System.out.println("Withdraw Successful");
        }  
        void checkBalance()
        {
            System.out.println("Balance is: " + this.balance);
        } 
}
