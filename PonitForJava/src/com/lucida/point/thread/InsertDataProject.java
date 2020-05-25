package com.lucida.point.thread;

import java.util.ArrayList;
import java.util.List;

public class InsertDataProject {

    List<String> mList = new ArrayList<>();
    public void insertData(String testData){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"插入数据："+testData);
            mList.add(Thread.currentThread().getName()+"插入数据："+testData);
        }
    }

    public synchronized void insertData_1(String testData){
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+"插入数据："+testData+"==数据条数:"+i);
            mList.add(Thread.currentThread().getName()+"插入数据："+testData);
        }
    }

    public synchronized static void insertData_2(String testData){
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+"插入数据："+testData+"==数据条数:"+i);
//            mList.add(Thread.currentThread().getName()+"插入数据："+testData);
        }
    }

    public void insertData_3(String testData){
        synchronized (SynchronizedStudy.class) {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + "插入数据：" + testData+"==数据条数:"+i);
                mList.add(Thread.currentThread().getName() + "插入数据：" + testData);
            }
        }

    }

    public void insertData_4(String testData){
        synchronized (this) {//同步一个代码块
            //它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + "插入数据：" + testData+"==数据条数:"+i);
                mList.add(Thread.currentThread().getName() + "插入数据：" + testData);
            }
        }

    }
}
