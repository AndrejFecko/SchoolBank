package transfer;

import account.BankAccount;
import account.BusinessAccount;
import account.StudentAccount;

public class WithdrawService {
    private static final double BUSINESS_SERVICE_FEE = 0.01;
    private static final int STUDENT_OVERDRAFT_LIMIT = -5000;

    public void withdraw(BankAccount account, double amount) {
        if (account == null) {
            throw new IllegalArgumentException("Účet nesmí být null.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Vybíraná částka musí být větší než 0.");
        }

        double fee = 0.0;
        if (account instanceof BusinessAccount) {
            fee = amount * BUSINESS_SERVICE_FEE;
        }

        double totalDeduction = amount + fee;
        double newBalance = account.getBalance() - totalDeduction;

        if (newBalance < getWithdrawLimit(account)) {
            throw new IllegalArgumentException("Nedostatečný zůstatek na účtu.");
        }

        account.setBalance(newBalance);
    }

    private int getWithdrawLimit(BankAccount account) {
        if (account instanceof StudentAccount) {
            return STUDENT_OVERDRAFT_LIMIT;
        }
        return 0;
    }
}