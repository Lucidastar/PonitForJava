package com.lucida.point.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        testLockExample();
    }

    private static void testLockExample(){
        LockExample lockExample = new LockExample();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            lockExample.func();
        });

        executorService.execute(() -> {
            lockExample.func();
        });
    }
}
