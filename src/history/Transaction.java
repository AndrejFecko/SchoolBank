package history;

import currency.Currency;

public class Transaction {

    private final String fromAccountNumber;
    private final String toAccountNumber;
    private final double amount;
    private final Currency currency;
    private final String type;

    public Transaction(String fromAccountNumber, String toAccountNumber, double amount, Currency currency, String type) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.currency = currency;
        this.type = type;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + ": " + currency.format(amount)
                + " | z: " + fromAccountNumber
                + " | na: " + toAccountNumber;
    }
}
