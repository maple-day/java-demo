package com.fangda.transmit;

import org.junit.Test;

public class Transmit_Test {

    @Test
    public void fun1() {
        Integer a = 210;
        Integer b = 220;
        swap(a, b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private void swap(Integer num1, Integer num2) {
        Integer temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    @Test
    public void fun2() {
        Person person = new Person(18, "张三");
        swap(person);
        System.out.println("person = " + person + ",name=" + person.getName());
    }

    private void swap(Person person) {
        person.setName("李四");
        System.out.println("person = " + person + ",name=" + person.getName());
    }

    @Test
    public void fun3() {
        Person person1 = new Person(18, "张三");
        Person person2 = new Person(17, "王二");
        swap(person1, person2);
        System.out.println("person1 = " + person1 + ",name=" + person1.getName());
        System.out.println("person2 = " + person2 + ",name=" + person2.getName());
    }

    private void swap(Person person1, Person person2) {
        Person temp = person1;
        person1 = person2;
        person2 = temp;
        System.out.println("temp_person1 = " + person1 + ",name=" + person1.getName());
        System.out.println("temp_person2 = " + person2 + ",name=" + person2.getName());
    }

    @Test
    public void fun4() {
        Person person1 = new Person(18, "张三");
        System.out.println("person1 = " + person1.getName());
//        person1 = new Person(15,"赵六");
//        System.out.println("person1 = " + person1.getName());
        swap01(person1);
        System.out.println("person1 = " + person1.getName());

    }

    private void swap01(Person person) {
        person = new Person(16, "王琦");
        System.out.println("person = " + person.getName());
    }


    @Test
    public void fun5(){
        int a = 10;
        fun5_swap(a);
        System.out.println(a);
    }

    public void fun5_swap(int v){
        v=100;
    }

    @Test
    public void fun6(){
        Person1 lisi = new Person1();
        int v = 1;
        lisi.setAge(v);
        lisi.setName("lisi");
        fun6_swap(lisi);
        System.out.println(lisi.toString());
    }

    private void fun6_swap(Person1 lisi) {
        lisi.setAge(2);
        System.out.println(lisi.toString());
    }


}
