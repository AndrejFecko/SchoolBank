package currency;

import account.BankAccount;
import history.TransferLoggerService;

public class CurrencyExchangeService {

    private final CurrencyConverter currencyConverter;
    private final TransferLoggerService transferLoggerService;

    public CurrencyExchangeService(CurrencyConverter currencyConverter, TransferLoggerService transferLoggerService) {
        this.currencyConverter = currencyConverter;
        this.transferLoggerService = transferLoggerService;
    }

    public void exchange(BankAccount bankAccount, Currency targetCurrency) {
        if (bankAccount == null || targetCurrency == null) {
            throw new IllegalArgumentException("Účet ani cílová měna nesmí být null.");
        }

        Currency originalCurrency = bankAccount.getCurrency();
        if (originalCurrency == targetCurrency) {
            throw new IllegalArgumentException("Účet už je vedený v měně " + targetCurrency + ".");
        }

        double originalBalance = bankAccount.getBalance();
        double newBalance = currencyConverter.convert(originalBalance, originalCurrency, targetCurrency);

        bankAccount.setCurrency(targetCurrency);
        bankAccount.setBalance(newBalance);

        transferLoggerService.logExchange(bankAccount.getAccountNumber(), originalBalance, originalCurrency, targetCurrency);
    }
}
