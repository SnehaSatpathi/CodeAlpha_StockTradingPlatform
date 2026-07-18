#  Stock Trading Platform - Java Swing GUI Application

##  Project Overview

Stock Trading Platform is a **GUI-based desktop application developed using Java Swing** that simulates a real-world stock trading system.
The application allows users to view available stocks, buy and sell shares, manage their portfolio, and track transaction history through an interactive graphical user interface.
This project is developed using **Object-Oriented Programming (OOP) principles** and is an enhanced GUI version of a console-based stock trading platform.


#  Features

##  1. Market Data Management

The application provides a market view where users can see available stocks with their details.

### Market Information Includes:

- Stock Symbol
- Company Name
- Stock Price
- Available Shares

### Available Stocks:

|   Symbol   |   Company   |   Price   |
|------------|-------------|-----------|
|    AAPL    |  Apple Inc. |  ₹195.50  |
|    TSLA    | Tesla Motors|  ₹250.75  |
|   GOOGLE   | Google LLC  |  ₹180.25  |
|    AMZN    |    Amazon   |  ₹175.40  |
|    MSFT    |  Microsoft  |  ₹420.10  |



#  2. Buy Stock Functionality

Users can purchase stocks from the market.

### Features:

- Select stock from available market stocks
- Enter quantity to buy
- Validate available balance
- Deduct purchase amount automatically
- Add purchased stocks to portfolio
- Generate transaction record

Example:

```
BUY | AAPL | Quantity: 5 | Price: ₹195.50
```



#  3. Sell Stock Functionality

Users can sell stocks available in their portfolio.

### Features:

- Select owned stock
- Enter selling quantity
- Check portfolio availability
- Update stock quantity
- Add selling amount to balance
- Generate transaction record

Example:

```
SELL | TSLA | Quantity: 2 | Price: ₹250.75
```



#  4. Portfolio Management

The portfolio module allows users to track their investments.

### Portfolio Displays:

- Owned stock symbols
- Number of shares
- Available balance

Example:

```
AAPL  - 10 Shares
TSLA  - 5 Shares
```



#  5. Transaction History

The system maintains complete records of all trading activities.

Transaction details include:

- Transaction Type (BUY/SELL)
- Stock Symbol
- Quantity
- Stock Price
- Total Amount
- Date and Time

Example:

```
BUY | GOOGLE | Qty: 3 | Price: ₹180.25 | Total: ₹540.75
```



#  Additional Enhancement: User Login System

A login interface has been added as an extra feature to provide a better user experience.

Features:

- Username and password input
- User session creation
- Personalized dashboard access

(Current implementation accepts any non-empty username and password.)



#  Graphical User Interface

The application is built using **Java Swing**.

### GUI Components Used:

- JFrame
- JPanel
- JLabel
- JButton
- JTextField
- JPasswordField
- JTable
- JScrollPane
- JComboBox



#  Dashboard

The dashboard provides easy navigation to all application modules:

- Market Data
- Buy Stock
- Sell Stock
- Portfolio
- Transaction History



#  Project Structure

```
StockTradingPlatform
│
├── src
│
├── model
│   ├── Stock.java
│   ├── User.java
│   ├── Transaction.java
│   └── Portfolio.java
│
├── gui
│   ├── LoginFrame.java
│   ├── Dashboard.java
│   ├── MarketFrame.java
│   ├── BuyStockFrame.java
│   ├── SellStockFrame.java
│   ├── PortfolioFrame.java
│   └── TransactionFrame.java
│
└── Main.java
```



#  Technology Stack

## Programming Language

- Java

## GUI Framework

- Java Swing

## Development Tools

- IntelliJ IDEA


## Java Version

- JDK 17+



#  Concepts Implemented

## Object-Oriented Programming

The project demonstrates:

### Encapsulation

- Private variables
- Getter and setter methods

### Classes and Objects

Implemented classes:

- Stock
- User
- Portfolio
- Transaction

### Constructors

Used for object initialization.

### Data Structures

Used:

- ArrayList
- HashMap

### Event Handling

Used for GUI interactions and button operations.



#  Application Flow

```
               LOGIN WINDOW
                    |
                    |
                 DASHBOARD
                    |
 ------------------------------------------------
 |              |              |                 |
Market        Buy            Sell          Portfolio
Data         Stock          Stock            View
  |
  |
JTable
  |
AAPL
TSLA
GOOGLE
AMAZON
MSFT
```



#  How To Run The Project

### Step 1: Clone Repository

```
git clone <repository-url>
```

### Step 2: Open Project

Open using:

- IntelliJ IDEA


### Step 3: Run Application

Execute:

```
Main.java
```

The application will start with the login window.



#  Login Details

The current version uses a simple login system.

Any non-empty credentials can be used.

Example:

```
Username: admin

Password: admin123
```



#  Future Enhancements

Possible improvements:

- MySQL database integration
- Secure authentication system
- User registration
- Real-time stock market API integration
- Portfolio performance charts
- Stock price prediction using Machine Learning
- Admin dashboard
- Investment analytics



#  Learning Outcomes

Through this project, the following concepts are demonstrated:

✅ Java Swing GUI Development  
✅ Object-Oriented Programming  
✅ Event Driven Programming  
✅ Data Structures in Java  
✅ Desktop Application Development  
✅ Software Design and Modularity  
✅ Real-world Trading System Simulation  





