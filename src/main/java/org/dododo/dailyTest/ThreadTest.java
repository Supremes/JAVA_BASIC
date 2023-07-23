package org.dododo.dailyTest;


import java.util.Random;
import java.util.concurrent.*;

public class ThreadTest {

    class ThreadOriginal extends Thread {
        @Override
        public void run() {
            System.out.println("Name: " + ThreadOriginal.class);
        }
    }

    class ThreadRun implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println("Name: " + ThreadRun.class);
        }
    }

    class ThreadCallable implements Callable<String> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() throws Exception {
            System.out.println("Name: " + ThreadCallable.class);
            return "dododo";
        }
    }

    public void ThreadPoolTest() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10L, TimeUnit.SECONDS, Executors.newWorkStealingPool());
        System.out.println(222);
    }

    public void test() throws Exception {
        FutureTask task = new FutureTask<>(new ThreadCallable());
        new Thread(task, "thread-callable").start();
        System.out.println(task.get());

        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future future = pool.submit(new ThreadCallable());
        Future futureRunTask = pool.submit(new ThreadRun());
        System.out.println("future-get: " + future.get());
        System.out.println("futureRunTask-get: " + futureRunTask.get());

    }


}
