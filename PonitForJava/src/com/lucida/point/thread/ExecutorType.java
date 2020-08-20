package com.lucida.point.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * 线程池的种类
 * https://blog.csdn.net/u011240877/article/details/73440993
 */
public class ExecutorType {
    public static void main(String[] args){
//        fixedThreadPoolDemo();
//        cachedThreadPoolDemo();
//        System.out.println(-1 << 29);
//        scheduledThreadPoolDemo();
        newSingleThreadExecutorDemo();
    }


    public static void fixedThreadPoolDemo(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);//指定线程数，都是核心线程
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
            executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return null;
                }
            });
        }
        if (executorService.isTerminated()){

        }
    }

    public static void cachedThreadPoolDemo(){
        ExecutorService executorService = Executors.newCachedThreadPool();//没有核心线程，没有缓存，只有非核心线程
        FutureTask<String> futureTask = null;
        for (int i = 0; i < 100; i++) {
            /*Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            };*/
//            executorService.execute(syncRunnable);

            futureTask = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(100);
                    return "测试";
                }
            });
            executorService.submit(futureTask);

            try {
                String s = futureTask.get();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }



    }

    public static void scheduledThreadPoolDemo(){
        ExecutorService executorService = Executors.newScheduledThreadPool(8);
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = () -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            };
            executorService.execute(syncRunnable);
        }

        executorService.shutdown();


    }

    public static void newSingleThreadExecutorDemo(){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = () -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            };
            singleThreadExecutor.execute(syncRunnable);
        }
    }
}
