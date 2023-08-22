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
            atomic.incrementAndGet();  //自增i++
        }, "线程A").start();
        new Thread(() -> {
            while (atomic.get() == 0) {

            }
            atomic.incrementAndGet();
            test();
        }, "线程B").start();
        new Thread(() -> {
            while (atomic.get() == 1) {

            }
            atomic.incrementAndGet();
            test();
        }, "线程C").start();
    }

    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
