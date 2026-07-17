package gui;

import model.Stock;
import model.Transaction;
import model.User;

import javax.swing.*;
import java.awt.*;

public class SellStockFrame extends JFrame {

    private JComboBox<String> stockBox;
    private JTextField quantityField;

    private User user;


    public SellStockFrame(User user) {

        this.user = user;

        setTitle("Sell Stock");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);


        JLabel title = new JLabel("Sell Stock");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(150, 20, 150, 30);



        JLabel stockLabel = new JLabel("Select Stock:");
        stockLabel.setBounds(50, 80, 100, 25);



        stockBox = new JComboBox<>();

        for (String symbol : user.getPortfolio()
                .getStocks()
                .keySet()) {

            stockBox.addItem(symbol);
        }

        stockBox.setBounds(160, 80, 150, 25);



        JLabel qtyLabel = new JLabel("Quantity:");
        qtyLabel.setBounds(50, 120, 100, 25);



        quantityField = new JTextField();
        quantityField.setBounds(160, 120, 150, 25);



        JButton sellButton = new JButton("Sell");

        sellButton.setBounds(140, 180, 100, 35);



        sellButton.addActionListener(e -> {

            try {

                String symbol =
                        stockBox.getSelectedItem().toString();


                int quantity =
                        Integer.parseInt(
                                quantityField.getText()
                        );



                boolean sold =
                        user.getPortfolio()
                                .sellStock(
                                        symbol,
                                        quantity
                                );


                if (sold) {


                    for (Stock stock :
                            MarketFrame.marketStocks) {


                        if (stock.getSymbol()
                                .equals(symbol)) {


                            stock.increaseShares(quantity);


                            double amount =
                                    stock.getPrice()
                                            * quantity;


                            user.addBalance(amount);



                            Transaction transaction =
                                    new Transaction(
                                            "SELL",
                                            symbol,
                                            quantity,
                                            stock.getPrice()
                                    );


                            user.getPortfolio()
                                    .addTransaction(transaction);



                            JOptionPane.showMessageDialog(
                                    this,
                                    "Stock Sold Successfully!"
                            );


                            dispose();

                            break;
                        }
                    }


                } else {


                    JOptionPane.showMessageDialog(
                            this,
                            "Not enough stocks in portfolio!"
                    );

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
        add(sellButton);


        setVisible(true);
    }
}
