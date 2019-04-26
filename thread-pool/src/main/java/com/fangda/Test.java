package com.fangda;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;


@Log
public class Test {

    private static List<Integer> list = new ArrayList<>();

    private static String output = "";

    public static void main(String[] args) {
//        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
//        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
//
//        ReentrantLock reentrantLock = new ReentrantLock();
//        Condition condition = reentrantLock.newCondition();
//        Condition condition1 = reentrantLock.newCondition();
//
//
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//        executorService.scheduleAtFixedRate(() -> {
//            log.info(Thread.currentThread().getName());
//        }, 5, 6, TimeUnit.SECONDS);
//
//        executorService.scheduleWithFixedDelay(() -> {
//            log.info(Thread.currentThread().getName());
//        }, 5, 5, TimeUnit.SECONDS);
//
//
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//        forkJoinPool.

//        fact(100);
//        log.info(list.size() + "");
//
//        foo(0);
//        foo(1);
//        log.info(output);
//
//        StringBuffer stringBuffer = new StringBuffer("abc");
//        stringBuffer.insert(1, "zzz");
//        log.info(stringBuffer.toString());

//        Integer integer = new Integer(0);
//        add3(integer);
//        log.info(integer.intValue() + "");

//        File.separator
    }



    private static void add3(Integer i) {
        int i1 = i.intValue();
        i1 += 3;
        i = new Integer(i1);
    }

    private static void foo(int n) {
        try {
            if (n == 1) throw new Exception();
            output += "A";
        } catch (Exception e) {
            output += "M";
            return;
        } finally {
            output += "C";
        }
        output += "G";

    }

    private static int fact(int n) {
        list.add(1);
        log.info("调用次数加1");
        if (n <= 0) {
            return 1;
        } else
            return n * fact(n - 1);

    }


    class sss extends RecursiveTask<Long> {

        @Override
        protected Long compute() {

            sss sss = new sss();
            sss.fork();


            return null;
        }
    }
}
