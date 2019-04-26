package com.fangda.concurrent.commonUnsafe;

import lombok.extern.java.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

@Log
public class DateFormatExample2 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    DateFormat dateFormat = threadLocal.get();
                    if (dateFormat == null) {
                        dateFormat = new SimpleDateFormat("yyyyMMdd");
                    }
                    Date parse = dateFormat.parse("20190419");
                    log.log(Level.INFO, parse.toString());
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                threadLocal.remove();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }
}
