package yunqiu.threadPool;

/**
 * Created by qiulig on 2021/9/10
 */
public class Order3_volatile {
    private volatile static int v = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            test();
            v = 1;
        }, "线程A").start();
        new Thread(() -> {
            while (v == 0) {

            }
            test();
            v = 2;
        }, "线程B").start();
        new Thread(() -> {
            while (v == 1) {

            }
            test();
        }, "线程C").start();
    }

    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
