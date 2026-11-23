class BankAccount{
    protected double balance=0;
    public BankAccount(double b){
        if(b<0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance=b;

    }
    public void withdraw(double amount){
        if(balance-amount<0){
            throw new RuntimeException("Insufficient funds.");

        }
        balance-=amount;
        System.out.println("Amount withdrawn. Remaining balance is : "+ balance);
    }
}
class FixedDepositAccount extends BankAccount{
    public FixedDepositAccount(double b){
        super(b);
    }
    @Override 
    public void withdraw(double amount){
        throw new RuntimeException("Withdrawal not allowed in fixed deposit account");
    }
}
class HistoryConstraint{
    public static void main(String[] args) {
        BankAccount bankAccount=new BankAccount(500);
        bankAccount.withdraw(100);   
    }
}