package history;

import currency.Currency;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {

    private final List<Transaction> history = new ArrayList<>();
    private final TransactionFactory transactionFactory;

    public TransferLoggerService(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }

    public void logTransfer(String fromAccountNumber, String toAccountNumber, double amount, Currency currency) {
        Transaction transaction = transactionFactory.newTransfer(fromAccountNumber, toAccountNumber, amount, currency);
        history.add(transaction);
    }

    public void logDeposit(String toAccountNumber, double amount, Currency currency) {
        Transaction transaction = transactionFactory.newDeposit(toAccountNumber, amount, currency);
        history.add(transaction);
    }

    public void logWithdraw(String fromAccountNumber, double amount, Currency currency) {
        Transaction transaction = transactionFactory.newWithdraw(fromAccountNumber, amount, currency);
        history.add(transaction);
    }

    public void logExchange(String accountNumber, double amount, Currency fromCurrency, Currency toCurrency) {
        Transaction transaction = transactionFactory.newExchange(accountNumber, amount, fromCurrency, toCurrency);
        history.add(transaction);
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public void printHistory() {
        IO.println("--- Historie transakcí ---");
        for (Transaction transaction : history) {
            IO.println(transaction);
        }
    }
}
