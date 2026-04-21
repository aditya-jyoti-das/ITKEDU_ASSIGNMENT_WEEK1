package assignment_3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    private final AtomicInteger atomicIndex = new AtomicInteger(-1);
    private String fullName;
    private LocalDateTime lastChange;
    private LocalDateTime created;
    private BigDecimal availableAmount;

    public BankAccount(String fullName, BigDecimal amount) {
        atomicIndex.incrementAndGet();
        this.fullName = fullName;
        this.lastChange = LocalDateTime.now();
        this.created = LocalDateTime.now();
        this.availableAmount = amount;
    }





    public void deposit(BigDecimal depositAmount) throws DepositException{
        synchronized (this) {
            try {
                this.availableAmount = this.availableAmount.add(depositAmount);
            } catch (Exception e) {
                throw new DepositException("Exception occurred during deposit");
            } finally {
                this.lastChange = LocalDateTime.now();
            }
        }
    }

    public void withDraw(BigDecimal withDrawAmount) throws WithdrawalException {
        synchronized (this) {
            BigDecimal temp = this.availableAmount.subtract(withDrawAmount);
            if (temp.compareTo(BigDecimal.ZERO) < 0) {
                throw new WithdrawalException("In sufficient balance to withdraw amount: %s from acc: %s name: %s ".formatted(withDrawAmount.toString(), this.atomicIndex.toString(), this.fullName));
            }
            this.availableAmount = temp;
            this.lastChange = LocalDateTime.now();
        }
    }

    public String getBalance() {
        return this.availableAmount.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BankAccount that = (BankAccount) obj;

        return this.atomicIndex.get() == that.atomicIndex.get() &&
                Objects.equals(this.fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atomicIndex.get(), fullName);
    }
}
