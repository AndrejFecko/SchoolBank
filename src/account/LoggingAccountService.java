package account;

import currency.Currency;
import person.AccountHolder;

public class LoggingAccountService extends AccountServiceDecorator {

    public LoggingAccountService(AccountService accountService) {
        super(accountService);
    }

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder, Currency currency) {
        IO.println(">>> Initiating current account creation...");
        BankAccount account = super.createCurrentAccount(accountHolder, currency);
        IO.println("<<< Current account created successfully.");
        return account;
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder, Currency currency) {
        IO.println(">>> Initiating business account creation...");
        BankAccount account = super.createBusinessAccount(accountHolder, currency);
        IO.println("<<< Business account created successfully.");
        return account;
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName, Currency currency) {
        IO.println(">>> Initiating student account creation...");
        BankAccount account = super.createStudentAccount(accountHolder, schoolName, currency);
        IO.println("<<< Student account created successfully.");
        return account;
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder, Currency currency) {
        IO.println(">>> Initiating savings account creation...");
        BankAccount account = super.createSavingsAccount(accountHolder, currency);
        IO.println("<<< Savings account created successfully.");
        return account;
    }
}