package account;

import person.AccountHolder;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(String ID, AccountHolder accountHolder, double balance, String accountType) {
        super(ID, accountHolder, balance, accountType);
    }

    @Override
    public void subtract(double amount) {
        double tax = amount * 0.01;
        double minus = amount + tax;
        super.subtract(minus);
    }
}
