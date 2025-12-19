package model;

import constant.AccountType;
import util.IDGenerator;

public class Account {
    protected String accountNumber;
    protected User user;
    protected double balance;
    protected AccountType accountType;
    IDGenerator id = new IDGenerator();

    public Account(User user, double balance, AccountType accountType) {
        this.user = user;
        this.balance = balance;
        this.accountType = accountType;
        this.accountNumber = id.generateAccountNo(accountType);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public User getUser() {
        return user;
    }

    public AccountType getAccountType(){
        return accountType;
    }

    public void deposit(double amount){
        balance = balance+amount;
    }
    public String withdraw(double amount){
        if(amount>balance) return "Insufficient Balance";
        balance = balance-amount;
        return  "Successfully withdraw";
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }
}
