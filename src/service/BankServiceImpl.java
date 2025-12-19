package service;

import constant.AccountType;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import model.User;
import repository.BankRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class BankServiceImpl implements BankService{

    @Override
    public void createAccount() {
        Scanner sc = new Scanner(System.in);

        // -------- USER INPUT --------
        System.out.println("enter details of user :");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobileNo = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        User user = new User(name,mobileNo,email,address);

        // -------- ACCOUNT INPUT --------
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter Account Type (1.SAVING  2.CURRENT): ");
        int choice = sc.nextInt();

        AccountType accountType;
        if (choice == 1) {
            accountType = AccountType.SAVING;
        } else {
            accountType = AccountType.CURRENT;
        }
        Account account = new Account(user, balance, accountType);
        System.out.println(user.toString());
        if (accountType == AccountType.SAVING){
            account = new SavingsAccount(user,balance);
            System.out.println(account.toString());
        }
        else {
            account =  new CurrentAccount(user,balance);
            System.out.println(account.toString());
        }
        BankRepository.accounts.put(account.getAccountNumber(),account);
        String record = LocalDateTime.now() + " | "+ "credit"+" | "+balance;
        BankRepository.transactions.add(record);

    }

    @Override
    public void depositMoney() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account number: ");
        String accNo = sc.nextLine();

        Account account = BankRepository.accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("Enter the deposit Money: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount is not valid because its 0 or other..");
            return;
        }
        double newBal = account.getBalance() + amount;
        account.setBalance(newBal);

        String record = LocalDateTime.now() + " | DEPOSIT | credit | " + amount + " | Balance=" + newBal;
        System.out.println(record);
        BankRepository.transactions.add(record);

        System.out.println(account.getBalance());

    }

    @Override
    public void withdrawMoney() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account number: ");
        String accNo = sc.nextLine();

        Account account = BankRepository.accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("Enter the Money you want to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > account.getBalance()){
            System.out.println("you dont have sufficient balance.");
        }
        else {
            double newBal = account.getBalance() - amount;
            account.setBalance(newBal);

            String record = LocalDateTime.now() + " | WITHDRAW | debit | " + amount + " | Balance=" + newBal;
            System.out.println(record);
            BankRepository.transactions.add(record);
        }

    }

    @Override
    public void showAccountDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account number: ");
        String accNo = sc.nextLine();

        Account account = BankRepository.accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }else {
            System.out.println(account);
        }


    }

    @Override
    public void showAllAccounts() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account number: ");
        String accNo = sc.nextLine();

        Account account = BankRepository.accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }else {
            System.out.println(BankRepository.accounts);
        }
    }
}
