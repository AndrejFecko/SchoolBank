package transfer;

import account.BankAccount;

import java.time.LocalDateTime;

public class TransactionRecordFactory {
    public static TransactionRecord create(String type, BankAccount account, double amount) {
        return new TransactionRecord(type, String.valueOf(account.getUuid()), amount, LocalDateTime.now());
    }
}
