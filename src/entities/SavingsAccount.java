package entities;

public class SavingsAccount extends BankAccount{

    private double minimumBalance = 200.0;
    private double rate = 0.005;

    public SavingsAccount(int number, String holder, double initialDeposit) {
        super(number, holder, initialDeposit);
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && getBalance() - amount  >= minimumBalance){
            debit(amount);
            return true;
        }
        return false;
    }
    public void applyMonthlyYield(){
        double interest = getBalance() * rate;
        deposit(interest);
        }
    }


