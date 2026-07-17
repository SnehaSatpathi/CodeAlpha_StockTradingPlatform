package model;

public class User {

    private String username;
    private String password;
    private double balance;
    private Portfolio portfolio;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 100000.00; // Initial trading balance
        this.portfolio = new Portfolio();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public boolean deductBalance(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void displayUserInfo() {
        System.out.println("Username: " + username);
        System.out.println("Balance: ₹" + balance);
    }
}