package Java_Day32;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit: " + amount + "Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw: " + amount + "Balance: " + balance);
        } else {
            System.out.println("no money");
        }
    }


}
class Bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(200);
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(1700);
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(200);
            }
        });
    }
}
