package yunqiu.threadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class Main_1116 {
    private static AtomicInteger atomic = new AtomicInteger(0);
    private static final int MAX_PRINT_NUM = 20;
    public static void main(String[] args) {
        //仅打印0
        new Thread(()->{
            while (atomic.get()<=MAX_PRINT_NUM){
                if(atomic.get()==0) {
                    printNum();
                    atomic.incrementAndGet();
                }
            }

        },"线程A").start();
        //仅打印奇数
        new Thread(()->{
            while (atomic.get()<=MAX_PRINT_NUM){
                if(atomic.get() % 2 == 1) {
                    printNum();
                    atomic.incrementAndGet();
                }
            }
        },"线程B").start();
        //仅打印偶数
        new Thread(()->{
            while (atomic.get()<=MAX_PRINT_NUM){
                if(atomic.get() % 2 == 0 && atomic.get() != 0) {
                    printNum();
                    atomic.incrementAndGet();
                }
            }
        },"线程C").start();
    }
    private static void printNum() {
        System.out.println(Thread.currentThread().getName()+":"+String.format("%02d",atomic.get()));
    }

}
