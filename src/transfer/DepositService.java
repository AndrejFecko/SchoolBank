package transfer;

import account.BankAccount;
import account.StudentAccount;

public class DepositService {
    private static final double STUDENT_BONUS = 0.005;

    public void deposit(BankAccount bankAccount, double amount) {
        if (bankAccount == null) {
            throw new IllegalArgumentException("Účet nesmí být null.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Vkládaná částka musí být větší než 0.");
        }

        double bonus = 0.0;
        if (bankAccount instanceof StudentAccount) {
            bonus = amount * STUDENT_BONUS;
        }

        bankAccount.setBalance(bankAccount.getBalance() + amount + bonus);
    }
}