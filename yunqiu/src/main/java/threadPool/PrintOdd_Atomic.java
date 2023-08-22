package threadPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintOdd_Atomic {
    // 打印何时结束需要设置一个上限，打印到100结束；
    private static final int MAX_PRINT_NUM = 100;
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        // 打印奇数
        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                // 打印奇数.
                if (atomicInteger.get() % 2 == 0) {
                    System.out.println("线程A:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();
        // 打印偶数.
        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                // 打印偶数.
                if (atomicInteger.get() % 2 == 1) {
                    System.out.println("线程B:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();
    }
}
