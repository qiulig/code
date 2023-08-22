package threadPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiulig on 2021/9/10
 */
public class Order2_AtomicInteger {
    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(0);
        new Thread(() -> {
            test();
            atomic.incrementAndGet();  //����i++
        }, "�߳�A").start();
        new Thread(() -> {
            while (atomic.get() == 0) {

            }
            atomic.incrementAndGet();
            test();
        }, "�߳�B").start();
        new Thread(() -> {
            while (atomic.get() == 1) {

            }
            atomic.incrementAndGet();
            test();
        }, "�߳�C").start();
    }

    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
