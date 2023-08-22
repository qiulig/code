package threadPool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qiulig on 2021/9/10
 */
public class Order1_countDownLatch {
    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(2);
        new Thread(() -> {
            test();
            //计数器减1
            count.countDown();
        }, "线程A").start();
        new Thread(() -> {
            while (count.getCount() == 2) {
                //线程等待
            }
            count.countDown();
            test();
        }, "线程B").start();
        new Thread(() -> {
            while (count.getCount() == 1) {
                //线程等待
            }
            test();
        }, "线程C").start();
    }

    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
