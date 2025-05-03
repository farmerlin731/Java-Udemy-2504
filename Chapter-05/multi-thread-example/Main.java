// launch threads - implement Runnable interface
class PrintNum implements Runnable {
    private int max;
    private char type;

    public PrintNum(int max, char type) {
        this.max = max;
        this.type = type;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.max; i++) {
            System.out.print(this.type + "" + i + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintNum(50, 'A'));
        Thread thread2 = new Thread(new PrintNum(66, 'B'));

        thread1.start();
        thread2.start();

        //Thread Pool Usage
        ExecutorService exeSer = Executors.newFixedThreadPool(4);
        exeSer.execute(new PrintNum(20,'C'));
        exeSer.execute(new PrintNum(30,'D'));
        exeSer.execute(new PrintNum(10,'E'));
        exeSer.execute(new PrintNum(10,'F'));

        exeSer.shutdown();
    }
}