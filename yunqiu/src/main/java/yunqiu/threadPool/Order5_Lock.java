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
        },"�߳�A").start();

        new Thread(()->{
            lock.lock();
            test();
            lock.unlock();
        },"�߳�B").start();
        new Thread(()->{
            lock.lock();
            test();
            lock.unlock();
        },"�߳�C").start();
    }
    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
