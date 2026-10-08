import account.*;
import person.AccountHolder;
import person.AccountHolderFactory;
import transfer.DepositService;
import transfer.TransferService;

public class Main {

    public static void main(String[] args) {
        AccountHolder holder = new AccountHolder("Andrej", "Fecko");

        AccountHolderFactory AccountHolderFactory = new AccountHolderFactory();

        BankAccount currentAccount = new CurrentAccount(AccountHolder);
        BankAccount businessAccount = new BusinessAccount(holder);
        BankAccount studentAccount = new StudentAccount(holder, "DELTA");

        DepositService depositService = new DepositService();
        TransferService transferService = new TransferService();

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
    }

    private static void printBalances(BankAccount current, BankAccount business, BankAccount student) {
        IO.println("Current:  " + current.getBalance() + " Kč");
        IO.println("Business: " + business.getBalance() + " Kč");
        IO.println("Student:  " + student.getBalance() + " Kč");
    }
}