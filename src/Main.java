import account.BankAccount;
import account.StudentAccount;
import person.AccountHolder;

public class Main {
    public static void main(String[] args) {
        AccountHolder accountHolder = new AccountHolder("Jan", "Novotný");
        System.out.println(accountHolder.getName());
        BankAccount bankAccount = new StudentAccount("8658965865", accountHolder, 22.2, "student");
    }
}




