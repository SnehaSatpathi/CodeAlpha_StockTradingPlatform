package gui;

import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PortfolioFrame extends JFrame {

    private User user;


    public PortfolioFrame(User user) {

        this.user = user;


        setTitle("My Portfolio");
        setSize(500, 400);
        setLocationRelativeTo(null);



        String[] columns = {
                "Stock Symbol",
                "Quantity"
        };


        DefaultTableModel model =
                new DefaultTableModel(columns, 0);



        for (String symbol :
                user.getPortfolio()
                        .getStocks()
                        .keySet()) {


            Object[] row = {

                    symbol,

                    user.getPortfolio()
                            .getStocks()
                            .get(symbol)
            };


            model.addRow(row);
        }



        JTable table = new JTable(model);


        JScrollPane scrollPane =
                new JScrollPane(table);



        JLabel balanceLabel =
                new JLabel(
                        "Available Balance: ₹"
                                + user.getBalance()
                );


        balanceLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );



        add(balanceLabel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);



        setVisible(true);
    }
}