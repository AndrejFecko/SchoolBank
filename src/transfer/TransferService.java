package transfer;

import account.BankAccount;

public class TransferService {
    private final WithdrawService withdrawService;
    private final DepositService depositService;

    public TransferService() {
        this(new WithdrawService(), new DepositService());
    }

    public TransferService(WithdrawService withdrawService, DepositService depositService) {
        this.withdrawService = withdrawService;
        this.depositService = depositService;
    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Odesílací ani cílový účet nesmí být null.");
        }
        if (fromAccount == toAccount || (fromAccount.getUuid() != null && fromAccount.getUuid().equals(toAccount.getUuid()))) {
            throw new IllegalArgumentException("Nelze převádět prostředky na stejný účet.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Převáděná částka musí být větší než 0.");
        }

        withdrawService.withdraw(fromAccount, amount);
        depositService.deposit(toAccount, amount);
    }
}