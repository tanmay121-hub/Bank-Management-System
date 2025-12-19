package model;

import constant.AccountType;
public class CurrentAccount extends Account{
    private static final double MAX_BALANCE = 100000;

    public CurrentAccount(User user, double balance) {
        super(user, balance, AccountType.CURRENT);
    }
    public double getMaxBalance(){
        return MAX_BALANCE;
    }

}
