package threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiulig on 2021/9/10
 */
public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,
                10,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(10),
                new ThreadPoolExecutor.AbortPolicy());
        // Ԥ�������к����߳�
        executor.prestartAllCoreThreads();

        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask("�߳�" + String.valueOf(i));
            executor.execute(task);

        }
    }

    static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(this.name + " is running!");
        }
    }

}

