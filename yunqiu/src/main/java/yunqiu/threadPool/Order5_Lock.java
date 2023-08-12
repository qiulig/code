package yunqiu.threadPool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qiulig on 2021/9/10
 */
public class Order5_Lock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(()->{
            test();
        },"线程A").start();

        new Thread(()->{
            lock.lock();
            test();
            lock.unlock();
        },"线程B").start();
        new Thread(()->{
            lock.lock();
            test();
            lock.unlock();
        },"线程C").start();
    }
    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
