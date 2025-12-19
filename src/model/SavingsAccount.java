package model;

import constant.AccountType;

public class SavingsAccount extends Account{
    private static final double MIN_BALANCE = 5000;
    public SavingsAccount(User user , double balance) {
        super(user, balance, AccountType.SAVING);
    }
    public double getMinBalance(){
        return MIN_BALANCE;
    }
}
