package com.fangda.concurrent.commonUnsafe;


import lombok.extern.java.Log;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

@Log
public class HashSetExample1 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static Set<Integer> set = new HashSet<>();
//    private static Set<Integer> set = ConcurrentHashMap.newKeySet(); 线程安全

//    private static ImmutableSet<Object> set = ImmutableSet.builder().build(); 不可以修改的 UnsupportedOperationException

//    static {
//        set = Collections.unmodifiableSet(set);  不可以修改改 UnsupportedOperationException
//    }


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int finalI = i;
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    set.add(finalI);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.log(Level.INFO, set.size() + "");
    }
}
