package account.serialization;

import java.io.*;

public class BankAccountSerialize {

    public void save(Object account, String file) throws Exception {
        new ObjectOutputStream(new FileOutputStream(file)).writeObject(account);
    }

    public Object load(String file) throws Exception {
        return new ObjectInputStream(new FileInputStream(file)).readObject();
    }
}