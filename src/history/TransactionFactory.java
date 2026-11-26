package history;

import currency.Currency;

public class TransactionFactory {

    public Transaction newTransfer(String fromAccountNumber, String toAccountNumber, double amount, Currency currency) {
        return new Transaction(fromAccountNumber, toAccountNumber, amount, currency, "TRANSFER");
    }

    public Transaction newDeposit(String toAccountNumber, double amount, Currency currency) {
        return new Transaction("-", toAccountNumber, amount, currency, "DEPOSIT");
    }

    public Transaction newWithdraw(String fromAccountNumber, double amount, Currency currency) {
        return new Transaction(fromAccountNumber, "-", amount, currency, "WITHDRAW");
    }

    public Transaction newExchange(String accountNumber, double amount, Currency fromCurrency, Currency toCurrency) {
        return new Transaction(accountNumber, accountNumber, amount, fromCurrency, "EXCHANGE " + fromCurrency + " -> " + toCurrency);
    }
}
