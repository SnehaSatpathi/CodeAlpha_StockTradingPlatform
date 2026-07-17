package gui;

import model.Stock;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MarketFrame extends JFrame {

    private JTable stockTable;
    private ArrayList<Stock> stocks;


    public static ArrayList<Stock> marketStocks = new ArrayList<>();


    public MarketFrame(User user) {

        setTitle("Market Data");
        setSize(600, 400);
        setLocationRelativeTo(null);


        if (marketStocks.isEmpty()) {
            loadStocks();
        }


        String[] columns = {
                "Symbol",
                "Company Name",
                "Price",
                "Available Shares"
        };


        DefaultTableModel model = new DefaultTableModel(columns, 0);


        for (Stock stock : marketStocks) {

            Object[] row = {
                    stock.getSymbol(),
                    stock.getCompanyName(),
                    "₹" + stock.getPrice(),
                    stock.getAvailableShares()
            };

            model.addRow(row);
        }


        stockTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(stockTable);


        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }



    private void loadStocks() {

        marketStocks.add(
                new Stock("AAPL", "Apple Inc.", 195.50, 1000)
        );

        marketStocks.add(
                new Stock("TSLA", "Tesla Motors", 250.75, 800)
        );

        marketStocks.add(
                new Stock("GOOGLE", "Google LLC", 180.25, 900)
        );

        marketStocks.add(
                new Stock("AMZN", "Amazon", 175.40, 700)
        );

        marketStocks.add(
                new Stock("MSFT", "Microsoft", 420.10, 600)
        );
    }
}
