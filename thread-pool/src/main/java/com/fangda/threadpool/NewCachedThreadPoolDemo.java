package com.fangda.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @classDesc: 功能描述:(线程池四种创建方式 newCachedThreadPool 创建可缓存的线程池)
 * @author:
 * @Version:v1.0
 * @createTime:2018年7月24日 下午2:56:16
 */
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) {
        // 1、创建可缓存的线程池 可以重复的利用
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            int temp = i;
            newCachedThreadPool.execute(() -> System.out.println("ThreadName:" + Thread.currentThread().getName() + " i:" + temp));
//            newCachedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("ThreadName:" + Thread.currentThread().getName() + " i:" + temp);
//                }
//            });
        }
    }
}