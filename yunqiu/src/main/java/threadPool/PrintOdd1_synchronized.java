package threadPool;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintOdd1_synchronized {
    private static final int MAX_PRINT_NUM = 100;
    //volatile��֤���̼߳�Ŀɼ���
    private static volatile int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 0) {
                    System.out.println("�߳�A:" + count);
                    count++;
                }
            }
        }).start();
        //?
        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 1) {
                    System.out.println("�߳�B:" + count);
                    count++;
                }
            }
        }).start();
    }
}
