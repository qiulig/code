package yunqiu.threadPool;

import java.util.concurrent.Semaphore;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintInOrder3_Semaphore {
    //如果这个Semaphore为零，如果另一线程调用(acquire)这个Semaphore就会产生阻塞
    private Semaphore spa = new Semaphore(0);
    private Semaphore spb = new Semaphore(0);

    public PrintInOrder3_Semaphore() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        spa.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        spa.acquire();
        printSecond.run();
        spb.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        spb.acquire();
        printThird.run();
    }

    //Semaphore 是一个计数信号量，必须由获取它的线程释放。
    // 常用于限制可以访问某些资源的线程数量，例如通过 Semaphore 限流。
    public static void main(String[] args) throws Exception {
        final PrintInOrder3_Semaphore foo = new PrintInOrder3_Semaphore();
        new Thread(()-> {
                try {
                    foo.first(()-> { System.out.println(1); });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        new Thread(()-> {
                try {
                    foo.second(()->{ System.out.println(2); });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();

        new Thread(()-> {
                try {
                    foo.third(()-> { System.out.println(3); });
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
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    foo.second(new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println(2);
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
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
//        t3.start();
//        t2.start();
//        t1.start();
    }
}
