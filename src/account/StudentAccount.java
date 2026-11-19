package account;

import notifier.NotifierService;
import person.AccountHolder;

public class StudentAccount extends BankAccount{

    private String schoolName;

    public StudentAccount(
            String accountNumber,
            AccountHolder accountHolder,
            String schoolName,
            NotifierService notifier
    ) {
        super(accountNumber, accountHolder, notifier);

        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
