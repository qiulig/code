package threadPool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintInOrder2_countDownLatch {
    //����2��countDownLatch
    private CountDownLatch countDownLatchA = new CountDownLatch(1);
    //˵��ֻҪһ���̵߳������ͷ��� �����ǵ�0�ͷ���
    private CountDownLatch countDownLatchB = new CountDownLatch(1);

    public PrintInOrder2_countDownLatch() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        printThird.run();
    }

    //countDownLatch�����ʹһ���̵߳ȴ������̸߳���ִ����Ϻ���ִ�С�
    //��ͨ��һ����������ʵ�ֵģ�
    // �������ĳ�ʼֵ���̵߳�������ÿ��һ���߳�ִ����Ϻ󣬼�������ֵ��-1��������- ����ֵΪ0ʱ����ʾ�����̶߳�ִ����ϣ�
    // Ȼ���ڱ����ϵȴ����߳̾Ϳ��Իָ������ˡ�
    public static void main(String[] args) throws Exception {
        final PrintInOrder2_countDownLatch foo = new PrintInOrder2_countDownLatch();

        new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.println(1);
                    //��һ�������߳�ִ�����ʱ���ͽ���������1
                    foo.countDownLatchA.countDown();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.println(2);
                    //��һ�������߳�ִ�����ʱ���ͽ���������1
                    foo.countDownLatchB.countDown();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> {
                    //�����߳�
                    try {
                        foo.countDownLatchB.await();
                        System.out.println(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    foo.first(new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println(1);
//                        }
//                    });
//                    //��һ�������߳�ִ�����ʱ���ͽ���������1
//                    foo.countDownLatchA.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //�����߳�
//                    foo.countDownLatchA.await();
//                    foo.second(new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println(2);
//                        }
//                    });
//                    //��һ�������߳�ִ�����ʱ���ͽ���������1
//                    foo.countDownLatchB.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //�����߳�
//                    foo.countDownLatchB.await();
//                    foo.third(new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println(3);
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//        t3.start();
    }
}
