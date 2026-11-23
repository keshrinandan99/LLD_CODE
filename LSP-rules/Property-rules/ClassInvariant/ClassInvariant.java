import javax.management.RuntimeErrorException;

class BankAccount{
    protected double balance;
    public BankAccount(double b){
        if(b<0){
            throw new IllegalArgumentException("Balance can't be negative");
        }
        balance=b;
    }
    public void withdrawBalance(double amount){
        if(balance-amount<0){
            throw new RuntimeException("Insufficient balance");
        }
        balance-=amount;
        System.out.println("Amount withdrawn. Remaining balance is :"+balance);
    }
}
class CheatAccount extends BankAccount{
    public CheatAccount(double b){
        super(b);
    }
    public void withdrawBalance(double amount){
        balance-=amount;
        System.out.println("Amount withdrawn. Remaining balance is : "+balance);
    }
}
public class ClassInvariant{
    public static void main(String[] args) {
        BankAccount bankAccount=new CheatAccount(500);
        bankAccount.withdrawBalance(501);
    }
}