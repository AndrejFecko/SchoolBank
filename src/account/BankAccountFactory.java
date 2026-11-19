package account;

import notifier.NotifierService;
import person.AccountHolder;

public class BankAccountFactory {

    private final ANG accountNumberGenerator;
    private final NotifierService notifierService;

    public BankAccountFactory(ANG accountNumberGenerator, NotifierService notifierService) {
        this.accountNumberGenerator = accountNumberGenerator;
        this.notifierService = notifierService;
    }

    public CurrentAccount newCurrentAccount(AccountHolder accountHolder) {
        String accountNumber = accountNumberGenerator.generate();
        return new CurrentAccount(accountNumber, accountHolder, notifierService);
    }

    public BusinessAccount newBusinessAccount(AccountHolder accountHolder) {
        String accountNumber = accountNumberGenerator.generate();
        return new BusinessAccount(accountNumber, accountHolder, notifierService);
    }

    public StudentAccount newStudentAccount(AccountHolder accountHolder, String schoolName) {
        String accountNumber = accountNumberGenerator.generate();
        return new StudentAccount(accountNumber, accountHolder, schoolName, notifierService);
    }

    public SavingsAccount newSavingsAccount(AccountHolder accountHolder) {
        String accountNumber = accountNumberGenerator.generate();
        return new SavingsAccount(accountNumber, accountHolder, notifierService);
    }
}
