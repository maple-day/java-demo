package com.fangda.threadpool;
 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
/**
 * 
 * @classDesc: 功能描述:(单线程的线程池)
 * @author:
 * @Version:v1.0
 * @createTime:2018年7月24日 下午3:57:15
 */
public class NewSingleThreadScheduledDemo {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int temp = i;
            newSingleThreadExecutor.execute(new Runnable() {
 
                @Override
                public void run() {
                    System.out.println("ThreadName:" + Thread.currentThread().getName() + " i:" + temp);
                }
            });
        }
    }
}