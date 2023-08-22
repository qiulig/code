package threadPool;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintInOrder4_LockSupport {
    static Thread t1 = null, t2 = null, t3 = null;

    public PrintInOrder4_LockSupport() {
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

    //park函数是将当前Thread阻塞，而unpark函数则是将另一个Thread唤醒。
    public static void main(String[] args) throws Exception {
        final PrintInOrder4_LockSupport foo = new PrintInOrder4_LockSupport();


        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName() + ":" + 1);
                        }
                    });
                    //唤醒线程t2
                    LockSupport.unpark(t2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        new Thread(()->{
//            try {
//                foo.first(()->{
//                    System.out.println(Thread.currentThread().getName()+":"+1);
//                    //唤醒线程t2
//                    LockSupport.unpark(t2);
//                });
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        },"线程A").start();


        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //阻塞当前线程
                LockSupport.park();
                try {
                    foo.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName() + ":" + 2);
                        }
                    });
                    //唤醒线程t3
                    LockSupport.unpark(t3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //阻塞当前线程
                LockSupport.park();
                try {
                    foo.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName() + ":" + 3);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}

