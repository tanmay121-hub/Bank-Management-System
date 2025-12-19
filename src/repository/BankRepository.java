package repository;

import model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {
    // store accounts
    public static Map<String, Account> accounts  = new HashMap<>();
    //store transactions
    public static List<String> transactions = new ArrayList<>();


    //prevent object creation
    private BankRepository(){

    }
}
