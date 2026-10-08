package account;

import java.security.SecureRandom;
import java.util.Random;

public class AccountNumberGenerator {

    private static final String PREFIX = "CZ";
    private static final Random RANDOM = new SecureRandom();
    public String generate() {
        return generate(PREFIX);
    }
    public String generate(String prefix) {
        StringBuilder string = new StringBuilder(prefix != null ? prefix : "");
        string.append(RANDOM.nextInt(10));
        return string.toString();
    }
}
