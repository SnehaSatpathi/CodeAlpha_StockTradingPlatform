package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private String stockSymbol;
    private int quantity;
    private double price;
    private String dateTime;

    public Transaction(String type, String stockSymbol, int quantity, double price) {
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.dateTime = LocalDateTime.now().format(formatter);
    }

    public String getType() {
        return type;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDateTime() {
        return dateTime;
    }

    public double getTotalAmount() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return type + " | "
                + stockSymbol + " | Qty: "
                + quantity + " | Price: ₹"
                + price + " | Total: ₹"
                + getTotalAmount()
                + " | " + dateTime;
    }
}
