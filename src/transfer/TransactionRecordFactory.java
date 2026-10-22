package transfer;

import account.BankAccountFactory;

import java.time.LocalDateTime;

public class TransactionRecordFactory {
    public static TransactionRecord create(String type, BankAccountFactory account, double amount) {
        return new TransactionRecord(type, String.valueOf(account.getUuid()), amount, LocalDateTime.now());
    }
}
