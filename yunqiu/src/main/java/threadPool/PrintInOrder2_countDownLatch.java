package threadPool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintInOrder2_countDownLatch {
    //定义2个countDownLatch
    private CountDownLatch countDownLatchA = new CountDownLatch(1);
    //说明只要一个线程调用它就放行 ，它是到0就放行
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

    //countDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行。
    //是通过一个计数器来实现的，
    // 计数器的初始值是线程的数量。每当一个线程执行完毕后，计数器的值就-1，当计数- 器的值为0时，表示所有线程都执行完毕，
    // 然后在闭锁上等待的线程就可以恢复工作了。
    public static void main(String[] args) throws Exception {
        final PrintInOrder2_countDownLatch foo = new PrintInOrder2_countDownLatch();

        new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.println(1);
                    //当一个任务线程执行完毕时，就将计数器减1
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
                    //当一个任务线程执行完毕时，就将计数器减1
                    foo.countDownLatchB.countDown();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> {
                    //唤醒线程
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
//                    //当一个任务线程执行完毕时，就将计数器减1
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
//                    //唤醒线程
//                    foo.countDownLatchA.await();
//                    foo.second(new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println(2);
//                        }
//                    });
//                    //当一个任务线程执行完毕时，就将计数器减1
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
//                    //唤醒线程
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
