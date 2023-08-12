package yunqiu.threadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class Main_1116 {
    private static AtomicInteger atomic = new AtomicInteger(0);
    private static final int MAX_PRINT_NUM = 20;
    public static void main(String[] args) {
        //����ӡ0
        new Thread(()->{
            while (atomic.get()<=MAX_PRINT_NUM){
                if(atomic.get()==0) {
                    printNum();
                    atomic.incrementAndGet();
                }
            }

        },"�߳�A").start();
        //����ӡ����
        new Thread(()->{
            while (atomic.get()<=MAX_PRINT_NUM){
                if(atomic.get() % 2 == 1) {
                    printNum();
                    atomic.incrementAndGet();
                }
            }
        },"�߳�B").start();
        //����ӡż��
        new Thread(()->{
            while (atomic.get()<=MAX_PRINT_NUM){
                if(atomic.get() % 2 == 0 && atomic.get() != 0) {
                    printNum();
                    atomic.incrementAndGet();
                }
            }
        },"�߳�C").start();
    }
    private static void printNum() {
        System.out.println(Thread.currentThread().getName()+":"+String.format("%02d",atomic.get()));
    }

}
