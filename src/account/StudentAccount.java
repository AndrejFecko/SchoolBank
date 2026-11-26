package account;

import currency.Currency;
import notifier.NotifierService;
import person.AccountHolder;

public class StudentAccount extends BankAccount{

    private String schoolName;

    public StudentAccount(
            String accountNumber,
            AccountHolder accountHolder,
            String schoolName,
            Currency currency,
            NotifierService notifier
    ) {
        super(accountNumber, accountHolder, currency, notifier);

        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
