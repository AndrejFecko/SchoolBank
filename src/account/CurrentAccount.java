package account;

import person.AccountHolder;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(String ID, AccountHolder accountHolder, double balance, String accountType) {
        super(ID, accountHolder, balance, accountType);
    }

    @Override
    public void add(double amount) {
        super.add(amount);
    }
}