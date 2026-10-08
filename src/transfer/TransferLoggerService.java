package transfer;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {
    private final List<TransactionRecord> records = new ArrayList<>();

    public void log(TransactionRecord record) {
        records.add(record);
    }

    public List<TransactionRecord> getRecords() {
        return records;
    }
}
