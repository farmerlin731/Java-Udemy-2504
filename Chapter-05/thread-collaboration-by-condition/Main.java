import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static Account account = new Account();

    private static class Account {
        // fields
        private int balance = 0;
        private final Lock lock = new ReentrantLock();
        private final Condition newDeposit = lock.newCondition();

        public int getBalance() {
            return this.balance;
        }

        public void deposit(int amount) {
            lock.lock();
            balance += amount;
            System.out.println("++Deposit $" + amount + ", the remaining balance is " + getBalance());
            newDeposit.signalAll();
            lock.unlock();
        }

        public void withdraw(int amount) {
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("? Try to withdraw " + amount + ", but we are waiting for a deposit");
                    newDeposit.await();
                }
                balance -= amount;
                System.out.println("-- Withdraw " + amount + ", the remaining balance is " + getBalance());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public static class DepositTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    account.deposit((int) (Math.random() * 40) + 5);
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                account.withdraw((int) (Math.random() * 20) + 5);
                try {
                    Thread.sleep(1000); // ✅ 在每次提款之後暫停 0.5 秒，降低 CPU 負擔
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    public static void main(String[]args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DepositTask());
        executorService.execute(new WithdrawTask());
        executorService.shutdown();
    }
}