package account;

import person.AccountHolder;

public class CurrentAccount extends BankAccountFactory {
    public CurrentAccount(String accountNumber, AccountHolder accountHolder) {
        super(accountNumber, accountHolder);
    }
}