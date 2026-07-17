package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Portfolio {

    private HashMap<String, Integer> stocks;
    private ArrayList<Transaction> transactions;

    public Portfolio() {
        stocks = new HashMap<>();
        transactions = new ArrayList<>();
    }

    // Add stock after buying
    public void buyStock(String symbol, int quantity) {
        stocks.put(symbol, stocks.getOrDefault(symbol, 0) + quantity);
    }

    // Remove stock after selling
    public boolean sellStock(String symbol, int quantity) {

        if (stocks.containsKey(symbol) && stocks.get(symbol) >= quantity) {

            int remaining = stocks.get(symbol) - quantity;

            if (remaining == 0) {
                stocks.remove(symbol);
            } else {
                stocks.put(symbol, remaining);
            }

            return true;
        }

        return false;
    }

    public HashMap<String, Integer> getStocks() {
        return stocks;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Calculate total portfolio value
    public double calculatePortfolioValue(ArrayList<Stock> marketStocks) {

        double total = 0;

        for (String symbol : stocks.keySet()) {

            int quantity = stocks.get(symbol);

            for (Stock stock : marketStocks) {

                if (stock.getSymbol().equals(symbol)) {
                    total += quantity * stock.getPrice();
                    break;
                }
            }
        }

        return total;
    }

    public void clearPortfolio() {
        stocks.clear();
        transactions.clear();
    }
}