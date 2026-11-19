package account;

import notifier.NotifierService;
import person.AccountHolder;

public class BusinessAccount extends BankAccount{
    public BusinessAccount(String accountNumber, AccountHolder accountHolder, NotifierService notifier) {
        super(accountNumber, accountHolder, notifier);
    }
}
