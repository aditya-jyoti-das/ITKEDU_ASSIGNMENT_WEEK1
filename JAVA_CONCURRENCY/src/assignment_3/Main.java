package assignment_3;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        ConcurrentBank bank = new ConcurrentBank();

        // Creating accounts
        BankAccount account1 = bank.createBankAccount("aditya", new BigDecimal(1000));
        BankAccount account2 = bank.createBankAccount("rom",new BigDecimal(500));

        // Transfers between accounts
        Thread transferThread1 = new Thread(() -> {
            try {
                bank.transfer(account1, account2, new BigDecimal(200));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread transferThread2 = new Thread(() -> {
            try {
                bank.transfer(account2, account1, new BigDecimal(100));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        transferThread1.start();
        transferThread2.start();


        try {
            transferThread1.join();
            transferThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Output total balance
        System.out.println("Total balance: " + bank.getTotalBalance());
        System.out.println("Total balance of Aditya: "+account1.getBalance());
        System.out.println("Total balance of rom: "+account2.getBalance());


    }
}
