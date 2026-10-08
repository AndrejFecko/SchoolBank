package transfer;

import java.time.LocalDateTime;

public class TransactionRecord {
    private final String type;          // "DEPOSIT" / "WITHDRAW"
    private final String accountUuid;
    private final double amount;
    private final LocalDateTime timestamp;

    TransactionRecord(String type, String accountUuid, double amount, LocalDateTime timestamp) {
        this.type = type;
        this.accountUuid = accountUuid;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getType() { return type; }
    public String getAccountUuid() { return accountUuid; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
