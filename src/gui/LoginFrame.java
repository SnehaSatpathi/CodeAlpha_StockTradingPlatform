package gui;

import model.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public static User currentUser;

    public LoginFrame() {

        setTitle("Stock Trading Platform - Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("Stock Trading Platform");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(70, 20, 300, 30);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 25);

        usernameField = new JTextField();
        usernameField.setBounds(150, 80, 170, 25);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 120, 100, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 120, 170, 25);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 170, 100, 30);


        loginButton.addActionListener(e -> {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());


            if (!username.isEmpty() && !password.isEmpty()) {

                currentUser = new User(username, password);

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!"
                );

                new Dashboard(currentUser);
                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter username and password"
                );
            }

        });


        panel.add(title);
        panel.add(userLabel);
        panel.add(usernameField);
        panel.add(passLabel);
        panel.add(passwordField);
        panel.add(loginButton);


        add(panel);
        setVisible(true);
    }
}