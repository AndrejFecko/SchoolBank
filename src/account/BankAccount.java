package account;

import person.AccountHolder;
import java.util.UUID;

public abstract class BankAccount {
    private String AccountNumber;
    private AccountHolder AccountHolder;
    private double Balance;
    private String AccountType;
    private String ID;

    public BankAccount(String ID, AccountHolder accountHolder, double balance, String accountType) {
        this.ID = UUID.randomUUID().toString();
        this.AccountNumber = ID;
        this.AccountHolder = accountHolder;
        this.Balance = balance;
        this.AccountType = accountType;
    }

    public void add(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("Cannot add less than 0");
        }
        this.Balance += amount;
    }

    public void subtract(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("Cannot subtract a negative amount");
        }
        this.Balance -= amount;
    }

    public String getAccountNumber() { return AccountNumber; }
    public void setAccountNumber(String accountNumber) { AccountNumber = accountNumber; }
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }
    public AccountHolder getAccountHolder() { return AccountHolder; }
    public void setAccountHolder(AccountHolder accountHolder) { AccountHolder = accountHolder; }
    public double getBalance() { return Balance; }
    public void setBalance(double balance) { Balance = balance; }
}