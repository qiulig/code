package threadPool;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintOdd1_synchronized {
    private static final int MAX_PRINT_NUM = 100;
    //volatile保证了线程间的可见性
    private static volatile int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 0) {
                    System.out.println("线程A:" + count);
                    count++;
                }
            }
        }).start();
        //?
        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 1) {
                    System.out.println("线程B:" + count);
                    count++;
                }
            }
        }).start();
    }
}
