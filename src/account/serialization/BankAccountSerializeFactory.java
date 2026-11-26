package account.serialization;

import account.BankAccount;

public class BankAccountSerializeFactory {

    public BankAccountSerialize createBankAccountSerialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize = new BankAccountSerialize();
        bankAccountSerialize.accountNumber = bankAccount.getAccountNumber();
        bankAccountSerialize.currency = bankAccount.getCurrency().name();
        return bankAccountSerialize;
    }
}
