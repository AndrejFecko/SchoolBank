package account;

import currency.Currency;
import notifier.NotifierService;
import person.AccountHolder;

public class BankAccountFactory {

    private final ANG accountNumberGenerator;
    private final NotifierService notifierService;

    public BankAccountFactory(ANG accountNumberGenerator, NotifierService notifierService) {
        this.accountNumberGenerator = accountNumberGenerator;
        this.notifierService = notifierService;
    }

    public CurrentAccount newCurrentAccount(AccountHolder accountHolder, Currency currency) {
        String accountNumber = accountNumberGenerator.generate();
        return new CurrentAccount(accountNumber, accountHolder, currency, notifierService);
    }

    public BusinessAccount newBusinessAccount(AccountHolder accountHolder, Currency currency) {
        String accountNumber = accountNumberGenerator.generate();
        return new BusinessAccount(accountNumber, accountHolder, currency, notifierService);
    }

    public StudentAccount newStudentAccount(AccountHolder accountHolder, String schoolName, Currency currency) {
        String accountNumber = accountNumberGenerator.generate();
        return new StudentAccount(accountNumber, accountHolder, schoolName, currency, notifierService);
    }

    public SavingsAccount newSavingsAccount(AccountHolder accountHolder, Currency currency) {
        String accountNumber = accountNumberGenerator.generate();
        return new SavingsAccount(accountNumber, accountHolder, currency, notifierService);
    }
}
