package com.fangda.concurrent;

import lombok.extern.java.Log;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;


@Log
public class Example1 {

    private static int count = 0;
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < clientTotal; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                    countDownLatch.countDown();
                    Thread.currentThread().sleep(2000l);
                    int a = 10/0;
                } catch (Exception e) {
                    log.log(Level.WARNING, ExceptionUtils.getStackTrace(e));
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.log(Level.INFO, "executorService:{}", executorService);
        log.log(Level.INFO, count + "");

    }
}
