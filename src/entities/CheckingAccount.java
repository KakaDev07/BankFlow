package entities;

public class CheckingAccount extends BankAccount{

    private double withdrawalFee = 5.0;

    @Override
    public boolean hasValidInitialDeposit(){
        if(getBalance() >= 100) {
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && getBalance() >= amount + withdrawalFee){
            debit(amount + withdrawalFee);
            return true;
        }
        return false;
    }

    public CheckingAccount(int number, String holder, double initialDeposit) {
        super(number, holder, initialDeposit);
    }

    public double getWithdrawalFee() {
        return withdrawalFee;
    }


}
