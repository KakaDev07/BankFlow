package services;
import entities.BankAccount;
import java.util.ArrayList;
import java.util.List;

public class BankService {

    private List<BankAccount> accounts = new ArrayList<>();

    public BankAccount findAccountByNumber(int number) {

        for (BankAccount account : accounts) {
            if (account.getNumber() == number) {
                return account;
            }
        }
        return null;
    }

    public boolean addAccount(BankAccount account){
        if(findAccountByNumber(account.getNumber()) != null){
            return false;
        } else if (account.hasValidInitialDeposit() != true){
            return false;
        }else{
        accounts.add(account);
                return true;
            }
        }

    }

