package yunqiu.threadPool;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.*;

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
        // 预启动所有核心线程
        executor.prestartAllCoreThreads();

        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask("线程"+String.valueOf(i));
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
            System.out.println(this.name+ " is running!");
        }
    }

}

