import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static Buffer buffer = new Buffer();

    private static class Buffer {
        private static final int CAPACITY = 1;
        private LinkedList<Integer> queue = new LinkedList<>();
        private static Lock lock = new ReentrantLock();
        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();

        public void write(int value) {
            lock.lock();
            try {
                while (queue.size() == CAPACITY) {
                    System.out.println("Buffer full. Producer waits.");
                    notFull.await();
                }
                queue.offer(value);
                System.out.println("✅ Producer actually wrote: " + value+", the size is "+queue.size());
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void read() {
            lock.lock();
            int value = 0;
            try {
                while (queue.isEmpty()) {
                    notEmpty.await();
                }
                value = queue.remove();
                System.out.println("Consumer reads " + value+", the size is:"+queue.size());
                notFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    buffer.read();
                    Thread.sleep((int) (Math.random() * 1000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                int i = 0;
                while (true) {
                    buffer.write(i++);
                    Thread.sleep((int) (Math.random() * 1000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[]args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Producer());
        executorService.execute(new Consumer());
        executorService.shutdown();
    }
}