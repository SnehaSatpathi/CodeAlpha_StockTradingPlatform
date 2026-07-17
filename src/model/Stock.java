package model;

public class Stock {

    private String symbol;
    private String companyName;
    private double price;
    private int availableShares;

    public Stock(String symbol, String companyName, double price, int availableShares) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.price = price;
        this.availableShares = availableShares;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableShares() {
        return availableShares;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableShares(int availableShares) {
        this.availableShares = availableShares;
    }

    public void increaseShares(int quantity) {
        availableShares += quantity;
    }

    public boolean decreaseShares(int quantity) {
        if (quantity <= availableShares) {
            availableShares -= quantity;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return symbol + " - " + companyName + " | Price: ₹" + price;
    }
}
