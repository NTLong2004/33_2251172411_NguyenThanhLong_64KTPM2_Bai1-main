// Lớp cha Account
public class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal failed: insufficient funds or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Lớp con SavingsAccount kế thừa Account
public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 100.0;

    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal failed: must maintain minimum balance of 100.");
        }
    }
}

// Lớp kiểm tra chức năng
public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(500);
        System.out.println("Initial balance: " + sa.getBalance());

        sa.withdraw(300);
        System.out.println("Balance after first withdrawal: " + sa.getBalance());

        sa.withdraw(300); // This should fail
        System.out.println("Balance after second withdrawal: " + sa.getBalance());
    }
}
