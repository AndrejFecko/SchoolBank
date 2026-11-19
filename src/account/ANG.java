package account;

import java.util.Random;

public class ANG {
    private static final String BANK_CODE = "6767";
    private static final int[] WEIGHTS = {6, 3, 7, 9, 10, 5, 8, 4, 2};
    private final Random random = new Random();

    public String generate() {
        while (true) {
            int baseNumber = 100_000_000 + random.nextInt(900_000_000);
            String baseStr = String.valueOf(baseNumber);

            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (baseStr.charAt(i) - '0') * WEIGHTS[i];
            }

            int checkDigit = (11 - (sum % 11)) % 11;
            if (checkDigit != 10) {
                return String.format("%s%d/%s", baseStr, checkDigit, BANK_CODE);
            }
        }
    }
}