public class Main{
    public static void main(String[] args){
        BankAccount newAcc = new BankAccount(1, "Sudeep");

        newAcc.deposit(100);

        newAcc.withdraw(50);
    }
}