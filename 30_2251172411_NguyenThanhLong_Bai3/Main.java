// Product: Account
public abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }
}

// ConcreteProduct: SavingsAccount
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
            System.out.println("Rút tiền thất bại: phải giữ số dư >= 100.");
        }
    }
}

// Creator: AccountFactory
public abstract class AccountFactory {
    public abstract Account createAccount(double initialBalance);
}

// ConcreteCreator: SavingsAccountFactory
public class SavingsAccountFactory extends AccountFactory {
    @Override
    public Account createAccount(double initialBalance) {
        return new SavingsAccount(initialBalance);
    }
}

// Main program để kiểm tra
public class Main {
    public static void main(String[] args) {
        AccountFactory factory = new SavingsAccountFactory();
        Account account = factory.createAccount(500);

        System.out.println("Số dư ban đầu: " + account.getBalance());
        account.withdraw(300);
        System.out.println("Số dư sau rút 300: " + account.getBalance());
        account.withdraw(300); // Rút lần 2, sẽ thất bại
        System.out.println("Số dư sau rút 300 lần nữa: " + account.getBalance());
    }
}
