package yunqiu.threadPool;

/**
 * Created by qiulig on 2021/9/10
 */
public class Order7_sleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> test(), "�߳�A");
        Thread.sleep(1000);
        t1.start();
        Thread t2 = new Thread(() -> test(), "�߳�B");
        Thread.sleep(1000);
        t2.start();
        Thread t3 = new Thread(() -> test(), "�߳�C");
        Thread.sleep(1000);
        t3.start();
    }
    private static void test() {
        System.out.println(Thread.currentThread().getName());
    }
}
