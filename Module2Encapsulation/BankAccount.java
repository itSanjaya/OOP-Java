public class BankAccount {
    private String accountHolder;
    private double balance;


    public BankAccount(String accountHolder){
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be null or empty. Standard Holder");
        }
        else{
            this.accountHolder = accountHolder.trim();
        }
        this.balance = 0.0;
    }

    public String getAccountHolder(){
        return this.accountHolder;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit (double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Adding amount cannot be zero or negative.");
        }
        this.balance += amount;
    }

    public void  withdraw (double amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("The withdrawl amount cannot be negative or zero");
        }
        if (amount > this.balance){
            throw new IllegalArgumentException("Insufficent balance");
        }
        this.balance -= amount;
    }
}

