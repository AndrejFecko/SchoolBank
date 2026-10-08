import account.*;
import person.AccountHolder;
import person.AccountHolderFactory;
import transfer.DepositService;
import transfer.TransferLoggerService;
import transfer.TransferService;

public class Main {

    public static void main(String[] args) {
        AccountHolder holder = new AccountHolder("Andrej", "Fecko");

        AccountHolderFactory AccountHolderFactory = new AccountHolderFactory();

        BankAccount currentAccount = createCurrentAccount("CZ001", holder);
        BankAccount businessAccount = createBusinessAccount("CZ002", holder);
        BankAccount studentAccount = createStudentAccount("CZ003", holder, "DELTA");

        TransferLoggerService logger = new TransferLoggerService();
        DepositService depositService = new DepositService(logger);
        TransferService transferService = new TransferService(logger);

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

        logger.getRecords().forEach(r ->
                IO.println(r.getTimestamp() + " " + r.getType() + " " + r.getAccountUuid() + " " + r.getAmount()));
    }

    private static void printBalances(BankAccount current, BankAccount business, BankAccount student) {
        IO.println("Current:  " + current.getBalance() + " Kč");
        IO.println("Business: " + business.getBalance() + " Kč");
        IO.println("Student:  " + student.getBalance() + " Kč");
    }
}