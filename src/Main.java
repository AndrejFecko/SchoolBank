import account.*;
import account.serialization.BankAccountSerializer;
import container.Container;
import container.ContainerFactory;
import history.TransferLoggerService;
import person.AccountHolder;
import person.AccountHolderService;
import transfer.DepositService;
import transfer.TransferService;

public class Main {

    public static void main(String[] args) {

        ContainerFactory containerFactory = new ContainerFactory();
        Container container = containerFactory.newContainerWithLogging();

        AccountHolderService accountHolderService = container.getAccountHolderService();
        AccountService accountService = container.getAccountService();
        DepositService depositService = container.getDepositService();
        TransferService transferService = container.getTransferService();
        TransferLoggerService transferLoggerService = container.getTransferLoggerService();
        BankAccountSerializer jsonSerializer = container.getJsonSerializer();
        BankAccountSerializer xmlSerializer = container.getXmlSerializer();

        AccountHolder holder = accountHolderService.createAccountHolder("Daniel", "Bisko");

        IO.println("CREATING ACCOUNTS");
        IO.println("=========");
        BankAccount currentAccount = accountService.createCurrentAccount(holder);
        BankAccount businessAccount = accountService.createBusinessAccount(holder);
        accountService.createSavingsAccount(holder);
        BankAccount studentAccount = accountService.createStudentAccount(holder, "DELTA");
        IO.println("=========");

        IO.println(xmlSerializer.serialize(currentAccount));
        IO.println(xmlSerializer.serializeAll(accountService.getBankAccounts()));

        IO.println(jsonSerializer.serialize(currentAccount));
        IO.println(jsonSerializer.serializeAll(accountService.getBankAccounts()));

        IO.println(currentAccount.getAccountNumber());
        depositService.deposit(currentAccount, 5000);
        depositService.deposit(businessAccount, 10000);

        printBalances(currentAccount, businessAccount, studentAccount);

        transferService.transfer(currentAccount, studentAccount, 1000);
        printBalances(currentAccount, businessAccount, studentAccount);

        transferService.transfer(businessAccount, currentAccount, 2000);
        printBalances(currentAccount, businessAccount, studentAccount);

        try {
            transferService.transfer(currentAccount, studentAccount, -500);
        } catch (IllegalArgumentException e) {
            IO.println("Zachycena chyba: " + e.getMessage());
        }

        try {
            transferService.transfer(currentAccount, currentAccount, 500);
        } catch (IllegalArgumentException e) {
            IO.println("Zachycena chyba: " + e.getMessage());
        }

        try {
            transferService.transfer(currentAccount, studentAccount, 999999);
        } catch (IllegalArgumentException e) {
            IO.println("Zachycena chyba: " + e.getMessage());
        }

        transferLoggerService.printHistory();
    }

    private static void printBalances(BankAccount current, BankAccount business, BankAccount student) {
        IO.println("Current:  " + current.getBalance() + " Kč");
        IO.println("Business: " + business.getBalance() + " Kč");
        IO.println("Student:  " + student.getBalance() + " Kč");
    }
}
