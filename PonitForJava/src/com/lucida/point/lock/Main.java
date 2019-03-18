package com.lucida.point.lock;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final InsertDataProject insertDataProject = new InsertDataProject();
        new Thread(() -> insertDataProject.insertData1("first")).start();
        new Thread(() -> insertDataProject.insertData1("second")).start();
    }

}

class InsertDataProject {
    List<String> mList = new ArrayList<>();
    public void insertData(String testData) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "插入数据：" + testData);
            mList.add(Thread.currentThread().getName() + "插入数据：" + testData);
        }

    }

    public synchronized void insertData1(String testData) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "插入数据：" + testData);
            mList.add(Thread.currentThread().getName() + "插入数据：" + testData);
        }

    }
}