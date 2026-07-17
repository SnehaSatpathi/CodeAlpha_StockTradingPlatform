package gui;

import model.Stock;
import model.Transaction;
import model.User;

import javax.swing.*;
import java.awt.*;

public class BuyStockFrame extends JFrame {

    private JComboBox<String> stockBox;
    private JTextField quantityField;

    private User user;


    public BuyStockFrame(User user) {

        this.user = user;

        setTitle("Buy Stock");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);


        JLabel title = new JLabel("Buy Stock");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(150, 20, 150, 30);


        JLabel stockLabel = new JLabel("Select Stock:");
        stockLabel.setBounds(50, 80, 100, 25);


        stockBox = new JComboBox<>();

        for (Stock stock : MarketFrame.marketStocks) {
            stockBox.addItem(stock.getSymbol());
        }

        stockBox.setBounds(160, 80, 150, 25);



        JLabel qtyLabel = new JLabel("Quantity:");
        qtyLabel.setBounds(50, 120, 100, 25);


        quantityField = new JTextField();
        quantityField.setBounds(160, 120, 150, 25);



        JButton buyButton = new JButton("Buy");
        buyButton.setBounds(140, 180, 100, 35);



        buyButton.addActionListener(e -> {

            try {

                String symbol = stockBox.getSelectedItem().toString();

                int quantity = Integer.parseInt(
                        quantityField.getText()
                );


                for (Stock stock : MarketFrame.marketStocks) {

                    if (stock.getSymbol().equals(symbol)) {


                        double totalCost =
                                stock.getPrice() * quantity;


                        if (stock.getAvailableShares() >= quantity
                                && user.deductBalance(totalCost)) {


                            stock.decreaseShares(quantity);


                            user.getPortfolio()
                                    .buyStock(symbol, quantity);


                            Transaction transaction =
                                    new Transaction(
                                            "BUY",
                                            symbol,
                                            quantity,
                                            stock.getPrice()
                                    );


                            user.getPortfolio()
                                    .addTransaction(transaction);



                            JOptionPane.showMessageDialog(
                                    this,
                                    "Stock Bought Successfully!"
                            );

                            dispose();


                        } else {

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Insufficient balance or shares!"
                            );
                        }

                        break;
                    }
                }


            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter valid quantity"
                );
            }

        });



        add(title);
        add(stockLabel);
        add(stockBox);
        add(qtyLabel);
        add(quantityField);
        add(buyButton);


        setVisible(true);
    }
}