# Bank Account Management System

Develop a class named `BankAccount`, which models a bank account with an account number, an account holder's name, and a balance.

## Class: `BankAccount`

### Attributes

- `accountNumber`: A unique integer that represents the bank account number.
- `accountHolderName`: A string that holds the name of the account holder.
- `balance`: An integer that represents the account balance.

### Methods

- `getAccountNumber()`: Returns the account number as an integer.
- `getAccountHolderName()`: Returns the account holder's name as a string.
- `getBalance()`: Returns the balance as an integer.
- `deposit(int amount)`: Accepts an amount to deposit into the bank account and updates the balance. Returns `void`.
- `withdraw(int amount)`: Accepts an amount to withdraw from the bank account, checks if the balance is sufficient, and updates the balance. Returns `void`.