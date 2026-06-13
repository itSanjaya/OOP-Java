public class Main{
    public static void main(String[] args){
        BankAccount newAccount = new BankAccount("Alex");

        System.out.println("Account holder: " + newAccount.getAccountHolder());

        newAccount.deposit(110);
        newAccount.withdraw(50);
        System.out.println("Current balance: " + newAccount.getBalance());
        newAccount.withdraw(60);
        System.out.println("Current balance: " + newAccount.getBalance());

    }
}