package currency;

public enum Currency {
    CZK("Kč"),
    EUR("€"),
    USD("$");

    private final String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String format(double amount) {
        return String.format("%.2f %s", amount, symbol);
    }
}
