package assignment_3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConcurrentBank {

    private final List<BankAccount> bankAccountList = new ArrayList<>();

    public BankAccount createBankAccount(String fullName, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount(fullName, amount);
        bankAccountList.add(bankAccount);
        return bankAccount;
    }

    public void transfer(BankAccount from, BankAccount to, BigDecimal amount) throws Exception {
        if(bankAccountList.contains(from) && bankAccountList.contains(to)){
            try {
                from.withDraw(amount);
                to.deposit(amount);
            } catch (WithdrawalException e) {
                throw new RuntimeException(e);
            } catch (DepositException e) {
                // must have occurred through to.deposite method
                // but at this point controller must have executed from.withdraw
                // method so we have to roll back this process by using below method.
                from.deposit(amount);
                throw new RuntimeException(e);
            }
        }else{
            throw new Exception("ONE OF THE BANK ACCOUNT DOES NOT EXIST IN DB!");
        }
    }

    public BigDecimal getTotalBalance() {
        return this.bankAccountList.stream()
                .map(x -> new BigDecimal(x.getBalance()))
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }
}
