package com.fangda.concurrent;

import lombok.extern.java.Log;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;

@Log
public class Example2 {


    @Test
    public void fun1() {

        int[] a = {1, 2, 3, 4};
        Integer[] b = {1, 2, 3, 4};

        List<int[]> ints = Arrays.asList(a);
        List<Integer> integers = Arrays.asList(b);
        System.out.println("integers = " + integers.size());
//        System.out.println("ints = " + ints.size());
//        int[] ints1 = ints.get(0);
//        System.out.println("ints1 = " + ints1.length);

    }

    @Test
    public void fun2() throws InterruptedException, ExecutionException {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        Condition condition = reentrantLock.newCondition();
//        condition.await();
//        condition.signal();


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        log.log(Level.INFO, System.currentTimeMillis() + "");
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(200000);
            return System.getProperty("a", "1123s");
        });
        log.log(Level.INFO, System.currentTimeMillis() + "");
        log.log(Level.INFO, System.currentTimeMillis() + ",future.get() = " + future.get());

    }

}
