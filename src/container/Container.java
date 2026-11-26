package container;

import account.ANG;
import account.AccountService;
import account.BankAccountFactory;
import account.BankAccountService;
import account.LoggingAccountService;
import account.TimeLoggingAccountService;
import account.serialization.BankAccountGsonSerializer;
import account.serialization.BankAccountJsonSerializer;
import account.serialization.BankAccountSerializeFactory;
import account.serialization.BankAccountSerializer;
import account.serialization.BankAccountXmlSerializer;
import currency.CurrencyConverter;
import currency.CurrencyExchangeService;
import history.TransactionFactory;
import history.TransferLoggerService;
import notifier.ConsoleNotifierService;
import notifier.NotifierService;
import person.AccountHolderFactory;
import person.AccountHolderService;
import transfer.DepositService;
import transfer.TransferService;
import transfer.WithdrawService;

public class Container {

    private final NotifierService notifierService;
    private final ANG accountNumberGenerator;
    private final CurrencyConverter currencyConverter;
    private final AccountHolderFactory accountHolderFactory;
    private final BankAccountFactory bankAccountFactory;
    private final TransactionFactory transactionFactory;
    private final BankAccountSerializeFactory bankAccountSerializeFactory;
    private final AccountHolderService accountHolderService;
    private final AccountService accountService;
    private final TransferLoggerService transferLoggerService;
    private final DepositService depositService;
    private final WithdrawService withdrawService;
    private final TransferService transferService;
    private final CurrencyExchangeService currencyExchangeService;
    private final BankAccountSerializer jsonSerializer;
    private final BankAccountSerializer xmlSerializer;
    private final BankAccountSerializer manualJsonSerializer;

    Container(boolean loggingEnabled) {
        notifierService = new ConsoleNotifierService();
        accountNumberGenerator = new ANG();
        currencyConverter = new CurrencyConverter();
        accountHolderFactory = new AccountHolderFactory();
        bankAccountFactory = new BankAccountFactory(accountNumberGenerator, notifierService);
        transactionFactory = new TransactionFactory();
        bankAccountSerializeFactory = new BankAccountSerializeFactory();

        accountHolderService = new AccountHolderService(accountHolderFactory);

        AccountService service = new BankAccountService(bankAccountFactory);
        if (loggingEnabled) {
            service = new TimeLoggingAccountService(new LoggingAccountService(service));
        }
        accountService = service;
        transferLoggerService = new TransferLoggerService(transactionFactory);
        depositService = new DepositService(transferLoggerService);
        withdrawService = new WithdrawService(transferLoggerService);
        transferService = new TransferService(transferLoggerService, currencyConverter);
        currencyExchangeService = new CurrencyExchangeService(currencyConverter, transferLoggerService);
        jsonSerializer = new BankAccountGsonSerializer(bankAccountSerializeFactory);
        xmlSerializer = new BankAccountXmlSerializer(bankAccountSerializeFactory);
        manualJsonSerializer = new BankAccountJsonSerializer(bankAccountSerializeFactory);
    }

    public NotifierService getNotifierService() {
        return notifierService;
    }

    public ANG getAccountNumberGenerator() {
        return accountNumberGenerator;
    }

    public CurrencyConverter getCurrencyConverter() {
        return currencyConverter;
    }

    public CurrencyExchangeService getCurrencyExchangeService() {
        return currencyExchangeService;
    }

    public AccountHolderFactory getAccountHolderFactory() {
        return accountHolderFactory;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    public BankAccountSerializeFactory getBankAccountSerializeFactory() {
        return bankAccountSerializeFactory;
    }

    public AccountHolderService getAccountHolderService() {
        return accountHolderService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public TransferLoggerService getTransferLoggerService() {
        return transferLoggerService;
    }

    public DepositService getDepositService() {
        return depositService;
    }

    public WithdrawService getWithdrawService() {
        return withdrawService;
    }

    public TransferService getTransferService() {
        return transferService;
    }

    public BankAccountSerializer getJsonSerializer() {
        return jsonSerializer;
    }

    public BankAccountSerializer getXmlSerializer() {
        return xmlSerializer;
    }

    public BankAccountSerializer getManualJsonSerializer() {
        return manualJsonSerializer;
    }
}
