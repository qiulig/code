package threadPool;

/**
 * Created by qiulig on 2021/9/10
 */
public class Order4_synchronized {
    private static int s = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            test();
            s++;
        }, "线程A").start();
        new Thread(() -> {
            synchronized (Order4_synchronized.class) {
                while (s == 0) {

                }
                test();
                s++;
            }
        }, "线程B").start();
        new Thread(() -> {
            synchronized (Order4_synchronized.class) {
                while (s == 1) {

                }
                test();
            }
        }, "线程C").start();
    }

    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
