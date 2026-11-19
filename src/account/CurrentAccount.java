package account;

import notifier.NotifierService;
import person.AccountHolder;

public class CurrentAccount extends BankAccount{
    public CurrentAccount(String accountNumber, AccountHolder accountHolder, NotifierService notifier) {
        super(accountNumber, accountHolder, notifier);
    }
}
