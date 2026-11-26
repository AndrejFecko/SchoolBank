package account;

import currency.Currency;
import notifier.NotifierService;
import person.AccountHolder;

public class CurrentAccount extends BankAccount{
    public CurrentAccount(String accountNumber, AccountHolder accountHolder, Currency currency, NotifierService notifier) {
        super(accountNumber, accountHolder, currency, notifier);
    }
}
