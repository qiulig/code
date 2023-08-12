package yunqiu.threadPool;

import java.util.concurrent.Semaphore;

/**
 * Created by qiulig on 2021/9/10
 */
public class PrintInOrder3_Semaphore {
    //������SemaphoreΪ�㣬�����һ�̵߳���(acquire)���Semaphore�ͻ��������
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

    //Semaphore ��һ�������ź����������ɻ�ȡ�����߳��ͷš�
    // ���������ƿ��Է���ĳЩ��Դ���߳�����������ͨ�� Semaphore ������
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
