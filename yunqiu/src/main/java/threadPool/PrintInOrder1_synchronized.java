package threadPool;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintInOrder1_synchronized {
    private int flag = 0;
    private Object lock = new Object();

    public PrintInOrder1_synchronized() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (flag != 0) {
                lock.wait();
            }
            printFirst.run();
            flag = 1;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            printThird.run();
            lock.notifyAll();
        }
    }

    //采用一个synchronized wait notifyAll 这些来实现的，
    // 但是吧，还需要一个while去自旋，还得靠一个信号量，
    public static void main(String[] args) throws Exception {
        final PrintInOrder1_synchronized foo = new PrintInOrder1_synchronized();

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

//        t3.start();
//        t2.start();
//        t1.start();
    }

}
