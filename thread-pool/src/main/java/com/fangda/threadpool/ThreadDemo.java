package com.fangda.threadpool;

import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class ThreadDemo {

    @Test
    public void fun() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());

            System.out.println("args = " + System.currentTimeMillis());
        });
        thread.start();
        thread.interrupt();
        thread.isInterrupted();
        System.out.println("thread getId= " + thread.getId());
        System.out.println("thread isAlive= " + thread.isAlive());
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 = " + System.currentTimeMillis());
            }
        });
        thread1.start();
    }

    @Test
    public void fun1() {
        int a = 45;
        int b = 45;
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println(b == a);
        Thread thread = new Thread(() -> {
            int c = 45;
            System.out.println("thread:" + Thread.currentThread().getName());
            System.out.println("thread ==:" + (a == c));
        });
        thread.start();
    }

}
