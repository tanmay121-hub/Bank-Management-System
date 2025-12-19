package util;

import constant.AccountType;

import java.time.LocalDate;
import java.util.UUID;

public class IDGenerator {
    public static int counter;
    public String generateAccountNo(AccountType accountType){
        String accountno = "ACC";
        if (accountType == AccountType.SAVING){
            accountno = accountno + "_sav_"+ LocalDate.now().getYear()+counter++;
        }else {
            accountno+="_curr_"+LocalDate.now().getYear()+counter++;
        }
        return accountno;
    }
    public String generateUserId(){
        return UUID.randomUUID().toString();
    }
}
