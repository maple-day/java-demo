package com.fangda.concurrent;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

public class AtomicIntegerFieldUpdaterExample {

    public class candidate {
        int a;
        int score;
    }

    public static void main(String[] args) throws InterruptedException {
//        AtomicIntegerFieldUpdater.newUpdater();
//
//        LongAdder longAdder = new LongAdder();
//        longAdder.decrement();
//        longAdder.sum();

        Thread[] ts = new Thread[10];
        LongAccumulator longAccumulator = new LongAccumulator(Long::max, Long.MIN_VALUE);


        for (int i = 0; i < 10; i++) {
            ts[i] = new Thread(() -> {
                Random random = new Random();
                Long nextLong = random.nextLong();
                System.out.println("nextLong = " + nextLong);
                longAccumulator.accumulate(nextLong);

            });

            ts[i].start();
        }

        for (Thread thread : ts) {
            thread.join();
        }

        System.out.println("longAccumulator = " + longAccumulator.longValue());
    }

    @Test
    public void fun(){

    }
}
