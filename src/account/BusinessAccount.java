package account;

import person.AccountHolder;

public class BusinessAccount extends BankAccountFactory {
    public BusinessAccount(String accountNumber, AccountHolder accountHolder) {
        super(accountNumber, accountHolder);
    }
}