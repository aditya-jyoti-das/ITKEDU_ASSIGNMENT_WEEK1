Practical Task – Concurrency – Multithreaded Bank Account
In the virtual bank "ConcurrentBank", it was decided to introduce multithreading to process customer account operations. The system must support concurrent deposits (deposit), withdrawals (withdraw), and transfers (transfer) between accounts. Each account has a unique account number.

Implement a BankAccount class with the methods deposit, withdraw, and getBalance, supporting multithreaded interaction.

Implement a ConcurrentBank class to manage accounts and perform transfers between them. The class should provide a createAccount method for creating a new account and a transfer method for performing transfers between accounts.

Transfers between accounts must be atomic to avoid situations where one part of a transaction is completed successfully while the other is not.

Implement a getTotalBalance method that returns the total balance of all accounts in the bank.