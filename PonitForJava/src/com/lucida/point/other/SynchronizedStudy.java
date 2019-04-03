package com.lucida.point.other;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedStudy {

    static {

    }

    public static void main(String[] args){
        System.out.println("hello world");
        final InsertDataProject insertDataProject = new InsertDataProject();
        final InsertDataProject insertDataProject2 = new InsertDataProject();
        new Thread("mine_first"){
            public void run() {
//                insertDataProject.insertData("first");
                insertDataProject.insertData3("first");
            };
        }.start();
        new Thread("mine_second"){
            public void run() {

                insertDataProject.insertData3("second");
            };
        }.start();

    }
}

class InsertDataProject{
    List<String> mList = new ArrayList<>();
    public void insertData(String testData){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"插入数据："+testData);
            mList.add(Thread.currentThread().getName()+"插入数据："+testData);
        }

    }

    public synchronized void insertData_1(String testData){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"插入数据："+testData);
            mList.add(Thread.currentThread().getName()+"插入数据："+testData);
        }
    }

    public synchronized static void insertData_2(String testData){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"插入数据："+testData);
//            mList.add(Thread.currentThread().getName()+"插入数据："+testData);
        }
    }

    public void insertData3(String testData){
        synchronized (SynchronizedStudy.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "插入数据：" + testData);
                mList.add(Thread.currentThread().getName() + "插入数据：" + testData);
            }
        }

    }
}
