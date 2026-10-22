package account;

import person.AccountHolder;

public class LoggingAccountService extends AccountServiceDecorator {

    public LoggingAccountService(AccountService accountService) {
        super(accountService);
    }

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder) {
        IO.println(">>> Initiating current account creation...");
        BankAccount account = super.createCurrentAccount(accountHolder);
        IO.println("<<< Current account created successfully.");
        return account;
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder) {
        IO.println(">>> Initiating business account creation...");
        BankAccount account = super.createBusinessAccount(accountHolder);
        IO.println("<<< Business account created successfully.");
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName) {
        IO.println(">>> Initiating student account creation...");
        BankAccount account = super.createStudentAccount(accountHolder, schoolName);
        IO.println("<<< Student account created successfully.");
        return account;
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder) {
        IO.println(">>> Initiating savings account creation...");
        BankAccount account = super.createSavingsAccount(accountHolder);
        IO.println("<<< Savings account created successfully.");
        return account;
    }
}