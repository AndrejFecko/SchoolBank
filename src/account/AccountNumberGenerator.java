package account;

import java.util.UUID;

public class AccountNumberGenerator {

    public String generate() {
        return UUID.randomUUID().toString();
    }
}