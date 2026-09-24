package account;

import person.AccountHolder;

public class StudentAccount extends BankAccount {

    public StudentAccount(String ID, AccountHolder accountHolder, double balance, String accountType) {
        super(ID, accountHolder, balance, accountType);
    }

    @Override
    public void add(double amount) {
        double bonus = amount * 0.05;
        double Add = amount + bonus;
        super.add(Add);
    }
    public void subtract(double balance,double amount) {
        if (balance-amount<-5000){
            throw new IllegalArgumentException("Cannot owe more than 5k");
        }
        super.subtract(amount);
    }
}