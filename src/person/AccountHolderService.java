package person;

import java.util.ArrayList;
import java.util.List;

public class AccountHolderService {

    private final AccountHolderFactory accountHolderFactory;
    private final List<AccountHolder> accountHolders = new ArrayList<>();

    public AccountHolderService(AccountHolderFactory accountHolderFactory) {
        this.accountHolderFactory = accountHolderFactory;
    }

    public AccountHolder createAccountHolder(String name, String lastName) {
        AccountHolder accountHolder = accountHolderFactory.newAccountHolder(name, lastName);
        accountHolders.add(accountHolder);
        return accountHolder;
    }

    public List<AccountHolder> getAccountHolders() {
        return accountHolders;
    }
}
