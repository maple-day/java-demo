package com.fangda.threadpool;
 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
/**
 * 
 * @classDesc: 功能描述:(可固定长度的线程池  newFixedThreadPool)
 * @author:李月
 * @Version:v1.0
 * @createTime:2018年7月24日 下午3:23:49
 */
public class newFixedThreadPoolDemo {
    public static void main(String[] args) {
        //快捷键 ctrl+2 +F 来创建变量名
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i++) {
            int temp = i;
            newFixedThreadPool.execute(new Runnable() {
 
                @Override
                public void run() {
                System.out.println("ThreadName:"+Thread.currentThread().getName()+" i:"+temp);  
                }
            });
        }
 
    }
}