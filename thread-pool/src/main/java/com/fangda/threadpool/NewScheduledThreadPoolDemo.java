package com.fangda.threadpool;
 
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
/**
 * 
 * @classDesc: 功能描述:(创建 可定时的线程池)
 * @author:
 * @Version:v1.0
 * @createTime:2018年7月24日 下午3:40:54
 */
public class NewScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for(int i = 0; i < 10; i++) {
            int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
 
                @Override
                public void run() {
                    System.out.println("ThreadName:"+Thread.currentThread().getName()+" i:"+temp);  
 
                }
            }, 3, TimeUnit.SECONDS);//定时3秒后 执行这个线程池
        }
    }
}