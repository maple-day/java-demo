package com.fangda.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ArrayListExample implements Runnable {

    //    private static List<Integer> list = new ArrayList<>();
//    private static List<Integer> list = new Vector<>();
//    private static List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//    private static List<Integer> list = Collections.emptyList();
    private static List<Integer> list = Arrays.asList(6,56,5);


    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(new ArrayListExample());
//        Thread thread2 = new Thread(new ArrayListExample());
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
        list.add(1);
        ListIterator<Integer> integerListIterator = list.listIterator();
        while (integerListIterator.hasNext()){
            Integer next = integerListIterator.next();
            System.out.println("next = " + next);
        }
        System.out.println("list.size() = " + list.size());



    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++)
            list.add(i);
    }
}
