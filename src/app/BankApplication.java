package app;

import constant.AccountType;
import model.Account;
import model.User;
import service.BankServiceImpl;

import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        BankServiceImpl b = new BankServiceImpl();
        b.createAccount();
        b.depositMoney();
        b.withdrawMoney();

    }
}
