package account.serialization;

import java.beans.*;
import java.io.*;

public class BankAccountXmlSerialize {

    public void save(Object account, String file) throws Exception {
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file))) {
            encoder.writeObject(account);
        }
    }

    public Object load(String file) throws Exception {
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(file))) {
            return decoder.readObject();
        }
    }
}