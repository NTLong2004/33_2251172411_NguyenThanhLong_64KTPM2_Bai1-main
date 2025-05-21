class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {

    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= 100) {
            return super.withdraw(amount);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(500);
        System.out.println("Withdraw 300: " + savings.withdraw(300));
        System.out.println("Withdraw another 300: " + savings.withdraw(300));
        System.out.println("Final balance: " + savings.getBalance());
    }
}
