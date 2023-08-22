package threadPool;

/**
 * Created by qiulig on 2021/9/10
 */
public class Order0_join {
    //���̲߳��б�ɴ���
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> test(), "�߳�A");
        Thread t2 = new Thread(() -> test(), "�߳�B");
        Thread t3 = new Thread(() -> test(), "�߳�C");
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
