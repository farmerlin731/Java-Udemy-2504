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
    }
}