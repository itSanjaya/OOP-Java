public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private int balance;

    public BankAccount(int acNo, String acName) {
        this.accountNumber = acNo;
        this.accountHolderName = acName;
        this.balance = 0;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("You deposited: " + amount);
        System.out.println("The current balance is: " + this.balance);
    }

    public void withdraw(int amount) {
        this.balance -= amount;
        System.out.println("You withdrew: " + amount);

        System.out.println("The current balance is: " + this.balance);
    }
}