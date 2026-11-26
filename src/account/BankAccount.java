package account;

import currency.Currency;
import notifier.NotifierService;
import person.AccountHolder;
import java.util.UUID;

public abstract class BankAccount {

    private String uuid;
    private AccountHolder accountHolder;
    private String accountNumber;
    private double balance;
    private Currency currency;

    private final NotifierService notifier;

    public BankAccount(String accountNumber, AccountHolder accountHolder, Currency currency, NotifierService notifier) {
        this.notifier = notifier;
        this.currency = currency;
        this.uuid = UUID.randomUUID().toString();
        this.balance = 0;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public String getUuid() {
        return uuid;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getFormattedBalance() {
        return currency.format(balance);
    }

    public void add(double amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.balance += amount;
        notifier.notify("Funds deposited successfully.");
    }

    public void sub(double amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.balance -= amount;
    }
}