package threadPool;

/**
 * Created by qiulig on 2021/9/10
 */
public class Order0_join {
    //将线程并行变成串行
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> test(), "线程A");
        Thread t2 = new Thread(() -> test(), "线程B");
        Thread t3 = new Thread(() -> test(), "线程C");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }

    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
