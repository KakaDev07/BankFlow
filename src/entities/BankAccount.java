package entities;

public class BankAccount {

    private int number;
    private String holder;
    private double balance;
    private double withdrawalFee = 5.0;


    public BankAccount(int number, String holder){
        this.number = number;
        this.holder = holder;
    }


    public BankAccount(int number, String holder, double initialDeposit){
        this.number = number;
        this.holder = holder;
        deposit(initialDeposit);
    }


    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }


    public boolean withdraw( double amount ) {
        if ( amount > 0 && balance >= amount + withdrawalFee){
            balance = balance - amount - withdrawalFee;
            return true;
        }
        return false;
      }


    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +  '}';
    }
}
