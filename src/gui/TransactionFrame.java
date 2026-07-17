package gui;

import model.Transaction;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TransactionFrame extends JFrame {

    private User user;


    public TransactionFrame(User user) {

        this.user = user;


        setTitle("Transaction History");
        setSize(700, 400);
        setLocationRelativeTo(null);



        String[] columns = {
                "Type",
                "Stock",
                "Quantity",
                "Price",
                "Total Amount",
                "Date & Time"
        };



        DefaultTableModel model =
                new DefaultTableModel(columns, 0);



        for (Transaction transaction :
                user.getPortfolio()
                        .getTransactions()) {


            Object[] row = {

                    transaction.getType(),

                    transaction.getStockSymbol(),

                    transaction.getQuantity(),

                    "₹" + transaction.getPrice(),

                    "₹" + transaction.getTotalAmount(),

                    transaction.getDateTime()
            };


            model.addRow(row);
        }



        JTable table = new JTable(model);


        JScrollPane scrollPane =
                new JScrollPane(table);



        JLabel title =
                new JLabel(
                        "All Trading Transactions"
                );


        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );


        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );



        add(title, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);



        setVisible(true);
    }
}