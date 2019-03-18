package com.lucida.point.lock;

public class SleepAndWait {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println(Thread.currentThread().getName());
        Object obj = new Object();
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("我睡一会");
                    Thread.sleep(2000);
                    synchronized (obj) {
                        obj.notify();
                    }
                    System.out.println("我给你解锁了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("开始");
                System.out.println("等我");
                System.out.println(Thread.currentThread().getName());
                synchronized (obj) {//
                    try {
                        obj.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("我来了");
            }
        }.start();




        //写两个线程 1.图片下载
        /*Object obj = new Object();
        Thread download = new Thread() {
            public void run() {
                System.out.println("开始下载图片");
                for (int i = 0; i < 101; i += 10) {
                    System.out.println("down" + i + "%");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("图片下载成功");
                synchronized (SleepAndWait.class) {
                    SleepAndWait.class.notify();//唤起
                }
                System.out.println("开始下载附件");
                for (int i = 0; i < 101; i += 10) {
                    System.out.println("附件下载" + i + "%");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("附件下载成功");
            }
        };
        //2.图片展示
        Thread show = new Thread() {
            public void run() {
                synchronized (SleepAndWait.class) {
                    try {
                        SleepAndWait.class.wait();//阻塞当前
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("show:开始展示图片");
                    System.out.println("图片展示完毕");
                }

            }
        };*/
//        download.start();
//        show.start();

/**
 * 图片下载成功
 * 开始下载附件
 * show:开始展示图片
 * 图片展示完毕
 */


    /*new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    new Thread(new Thread2()).start();*/

    }

    private static class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("enter thread1.....");
            System.out.println("thread1 is waiting.....");
            synchronized (SleepAndWait.class) {
                try {
                    SleepAndWait.class.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread1 is going.....");
            System.out.println("thread1 is over.....");
        }
    }

    private static class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("enter thread2.....");
            System.out.println("thread2 is waiting.....");
            synchronized (SleepAndWait.class) {
                SleepAndWait.class.notify();
            }
            System.out.println("thread2 is going.....");
            System.out.println("thread2 is over.....");
        }
    }
}
