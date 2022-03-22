package zaropotpot.settlers;

public class Settler {

    private String nameOfSettler;
    private int amountOfTobacco;
    private int expectedIncome;
    public static final int PRICE_PER_TON = 500;

    public Settler(String nameOfSettler, int amountOfTobacco) {
        this.nameOfSettler = nameOfSettler;
        this.amountOfTobacco = amountOfTobacco;
        this.expectedIncome = PRICE_PER_TON * amountOfTobacco;
    }

    public Settler(String nameOfSettler, int amountOfTobacco, int expectedIncome) {
        this(nameOfSettler,amountOfTobacco);
        this.expectedIncome = expectedIncome;
    }

    public String getNameOfSettler() {
        return nameOfSettler;
    }

    public int getAmountOfTobacco() {
        return amountOfTobacco;
    }

    public int getExpectedIncome() {
        return expectedIncome;
    }
}
