package account;

import notifier.NotifierService;
import person.AccountHolder;
import java.util.UUID;

public abstract class BankAccount {

    private String uuid;
    private AccountHolder accountHolder;
    private String accountNumber;
    private double balance;

    private final NotifierService notifier;

    public BankAccount(String accountNumber, AccountHolder accountHolder, NotifierService notifier) {
        this.notifier = notifier;
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