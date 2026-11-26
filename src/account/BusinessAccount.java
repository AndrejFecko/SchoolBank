package account;

import currency.Currency;
import notifier.NotifierService;
import person.AccountHolder;

public class BusinessAccount extends BankAccount{
    public BusinessAccount(String accountNumber, AccountHolder accountHolder, Currency currency, NotifierService notifier) {
        super(accountNumber, accountHolder, currency, notifier);
    }
}
