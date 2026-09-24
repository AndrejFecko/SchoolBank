package account;

import person.AccountHolder;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String ID, AccountHolder accountHolder, double balance, String accountType) {
        super(ID, accountHolder, balance, accountType);
    }

    @Override
    public void add(double amount) {
        double bonus = amount * 0.05;
        double Add = amount + bonus;
        super.add(Add);
    }
}
