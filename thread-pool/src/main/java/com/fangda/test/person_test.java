package com.fangda.test;

import lombok.extern.java.Log;
import org.junit.Test;

import java.util.logging.Level;

@Log
public class person_test {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.err.println(e);
            }
            System.out.println(System.currentTimeMillis());
        });
        thread.start();
        thread.interrupt();

    }


    @Test
    public void fun() {
        Integer a = 99;
        int i = a % 2;
        System.out.println("i = " + i);

        String s = Integer.toBinaryString(-99);
        System.out.println("s = " + s);
    }


    @Test
    public void fun3() {
        Person person = new SonPerson();
        SonPerson sonPerson = new SonPerson();
        log.log(Level.INFO, person.name);
        log.log(Level.INFO, sonPerson.name);

    }

    @Test
    public void fun4() {
        String a = "asc";
        check(a);
    }

    public void check(Object obj) {
        boolean b = obj instanceof String;
        if (b) {
            log.log(Level.INFO, b + "");
        }
        String simpleName = obj.getClass().getTypeName();
        String name = obj.getClass().getName();
        log.log(Level.INFO, simpleName);
        log.log(Level.INFO, name);

    }

    @Test
    public void fun5(){
        String aa = System.getProperty("aa");

    }

}
