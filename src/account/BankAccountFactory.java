package account;

import person.AccountHolder;

public class BankAccountFactory {

    private final AccountNumberGenerator accountNumberGenerator;

    public BankAccountFactory() {
        this(new AccountNumberGenerator());
    }

    public BankAccountFactory(AccountNumberGenerator accountNumberGenerator) {
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public CurrentAccount createCurrentAccount(AccountHolder accountHolder) {
        String accountNumber = accountNumberGenerator.generate();
        return new CurrentAccount(accountNumber, accountHolder);
    }

    public BusinessAccount createBusinessAccount(AccountHolder accountHolder) {
        String accountNumber = accountNumberGenerator.generate();
        return new BusinessAccount(accountNumber, accountHolder);
    }

    public StudentAccount createStudentAccount(AccountHolder accountHolder, String schoolName) {
        String accountNumber = accountNumberGenerator.generate();
        return new StudentAccount(accountNumber, accountHolder, schoolName);
    }

    public SavingsAccount createSavingsAccount(AccountHolder accountHolder) {
        String accountNumber = accountNumberGenerator.generate();
        return new SavingsAccount(accountNumber, accountHolder);
    }
}