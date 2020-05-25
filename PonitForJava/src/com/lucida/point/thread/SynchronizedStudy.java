package com.lucida.point.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedStudy {

    static {

    }

    public static void main(String[] args) {
//        testInsert_4();
//        testInsert_3();
//        testInsert_2();
        testInsert_1();
    }


    /**
     * synchronized (this)  它只作用于同一个对象，如果调用两个对象上的同步代码块，它是不会进行同步的，
     * 1、当只调用insertDataProject对象时，是会进行同步的，会等待其中一个插入完成后再进入另一个插入
     * 2、当创建了两个InsertDataProject，是不会影响同步的，是会交替的进行插入的操作
     */
    private static void testInsert_4() {
        InsertDataProject insertDataProject = new InsertDataProject();
        InsertDataProject insertDataProject2 = new InsertDataProject();
        Thread threadFirst = new Thread("mine_first") {
            public void run() {
                insertDataProject.insertData_4("first");
            }
        };

        Thread threadSecond = new Thread("mine_second") {
            public void run() {
                insertDataProject2.insertData_4("second");
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(threadFirst);
        executorService.execute(threadSecond);
    }

    /**
     * synchronized (SynchronizedStudy.class)同步一个类
     * 1、当是同一个类时，两个线程也会同步，会等待其中一个线程执行完后才会执行另一个线程
     * 2、当创建两个对象时，两个线程也会同步，会等待其中一个线程执行完后才会执行另一个线程
     *
     * 就是说两个线程调用同一个类的不同对象的这种同步语句，也会进行同步的
     *
     */
    private static void testInsert_3() {
        InsertDataProject insertDataProject = new InsertDataProject();
        InsertDataProject insertDataProject2 = new InsertDataProject();
        Thread threadFirst = new Thread("mine_first") {
            public void run() {
                insertDataProject.insertData_3("first");
            }
        };

        Thread threadSecond = new Thread("mine_second") {
            public void run() {
                insertDataProject2.insertData_3("second");
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(threadFirst);
        executorService.execute(threadSecond);
    }

    /**
     * synchronized static void insertData_2  静态方法上进行同步
     *1、当是同一个对象时，同时调用insertData_2，也会进行同步，会等其中一个线程执行完成后才会执行另一个
     *2、当创建两个对象时，同时调用insertData_2，也会进行同步，会等其中一个线程执行完成后才会执行另一个
     *
     * 它的作用相当于作用于一个类，如同testInsert_3方法中
     *
     */
    private static void testInsert_2() {
        InsertDataProject insertDataProject = new InsertDataProject();
        InsertDataProject insertDataProject2 = new InsertDataProject();
        Thread threadFirst = new Thread("mine_first") {
            public void run() {
                insertDataProject.insertData_2("first");
            }
        };

        Thread threadSecond = new Thread("mine_second") {
            public void run() {
                insertDataProject2.insertData_2("second");
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(threadFirst);
        executorService.execute(threadSecond);
    }

    /**
     * 同步一个方法  public synchronized void insertData_1
     *
     * 它和同步代码块一样 如同 testInsert_3
     */
    private static void testInsert_1() {
        InsertDataProject insertDataProject = new InsertDataProject();
        InsertDataProject insertDataProject2 = new InsertDataProject();
        Thread threadFirst = new Thread("mine_first") {
            public void run() {
                insertDataProject.insertData_1("first");
            }
        };

        Thread threadSecond = new Thread("mine_second") {
            public void run() {
                insertDataProject.insertData_1("second");
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(threadFirst);
        executorService.execute(threadSecond);
    }
}
