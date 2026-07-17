package gui;

import model.User;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private User user;

    public Dashboard(User user) {

        this.user = user;

        setTitle("Stock Trading Platform - Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(null);


        JLabel title = new JLabel("Welcome, " + user.getUsername());
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(170, 30, 300, 40);


        JLabel balanceLabel = new JLabel(
                "Available Balance: ₹" + user.getBalance()
        );
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        balanceLabel.setBounds(170, 80, 300, 30);



        JButton marketButton = new JButton("Market Data");
        marketButton.setBounds(70, 140, 150, 40);


        JButton buyButton = new JButton("Buy Stock");
        buyButton.setBounds(240, 140, 150, 40);


        JButton sellButton = new JButton("Sell Stock");
        sellButton.setBounds(410, 140, 120, 40);


        JButton portfolioButton = new JButton("View Portfolio");
        portfolioButton.setBounds(150, 220, 150, 40);


        JButton transactionButton = new JButton("Transaction History");
        transactionButton.setBounds(330, 220, 170, 40);



        marketButton.addActionListener(e -> {
            new MarketFrame(user);
        });


        buyButton.addActionListener(e -> {
            new BuyStockFrame(user);
        });


        sellButton.addActionListener(e -> {
            new SellStockFrame(user);
        });


        portfolioButton.addActionListener(e -> {
            new PortfolioFrame(user);
        });


        transactionButton.addActionListener(e -> {
            new TransactionFrame(user);
        });



        panel.add(title);
        panel.add(balanceLabel);
        panel.add(marketButton);
        panel.add(buyButton);
        panel.add(sellButton);
        panel.add(portfolioButton);
        panel.add(transactionButton);


        add(panel);
        setVisible(true);
    }
}
