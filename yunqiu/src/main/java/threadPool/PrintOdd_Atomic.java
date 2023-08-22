package threadPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintOdd_Atomic {
    // ��ӡ��ʱ������Ҫ����һ�����ޣ���ӡ��100������
    private static final int MAX_PRINT_NUM = 100;
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        // ��ӡ����
        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                // ��ӡ����.
                if (atomicInteger.get() % 2 == 0) {
                    System.out.println("�߳�A:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();
        // ��ӡż��.
        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                // ��ӡż��.
                if (atomicInteger.get() % 2 == 1) {
                    System.out.println("�߳�B:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();
    }
}
