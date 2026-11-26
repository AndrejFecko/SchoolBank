package currency;

import java.util.EnumMap;
import java.util.Map;

public class CurrencyConverter {

    public static final int EUR_TO_CZK = 25;

    private final Map<Currency, Double> ratesToCzk = new EnumMap<>(Currency.class);

    public CurrencyConverter() {
        ratesToCzk.put(Currency.CZK, 1.0);
        ratesToCzk.put(Currency.EUR, (double) EUR_TO_CZK);
        ratesToCzk.put(Currency.USD, 23.0);
    }

    public double convert(double amount, Currency from, Currency to) {
        if (from == to) {
            return amount;
        }
        return amount * ratesToCzk.get(from) / ratesToCzk.get(to);
    }

    public double getRate(Currency from, Currency to) {
        return convert(1, from, to);
    }

    public String formatConverted(double amount, Currency from, Currency to) {
        return to.format(convert(amount, from, to));
    }
}
