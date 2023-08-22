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
            //��������1
            count.countDown();
        }, "�߳�A").start();
        new Thread(() -> {
            while (count.getCount() == 2) {
                //�̵߳ȴ�
            }
            count.countDown();
            test();
        }, "�߳�B").start();
        new Thread(() -> {
            while (count.getCount() == 1) {
                //�̵߳ȴ�
            }
            test();
        }, "�߳�C").start();
    }

    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
