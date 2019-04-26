package com.fangda.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public List<Employee> employees = Arrays.asList(
            new Employee(18, "张三", 1996.66),
            new Employee(28, "李四", 9996.66),
            new Employee(58, "王五", 5996.66),
            new Employee(35, "赵六", 6444.66),
            new Employee(35, "赵六", 6444.66),
            new Employee(35, "赵六", 6444.66),
            new Employee(60, "田七", 19996.66)
    );

    @Test
    public void fun1() {
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .skip(2) //跳过前两个
                .distinct()//去重，注意：需要Employee重写hashCode 和 equals 方法
                .forEach(System.out::println);
    }


    @Test
    public void fun() {
        //1.可以通过Collection 系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过 Arrays 中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.通过Stream 类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }


    @Test
    public void fun2() {
        //内部迭代
        employees.stream().filter(employee -> employee.getAge() > 20).forEach(System.out::println);
        System.out.println("==============================================================================");

        //外部迭代
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println("employee = " + employee);
        }

    }

    @Test
    public void fun3() {

        //没有终止操作,中间操作不会执行任何的处理！

        Stream<Employee> employeeStream = employees.stream().distinct().filter(e -> {
            System.out.println("---------------短路--------------------");
            return e.getAge() > 20;
        });

        System.out.println(" ===========================中间操作========================== ");


        employeeStream.forEach(System.out::println);
    }

    /**
     * * 映射
     * * map--接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素。
     * * flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */

    @Test
    public void fun4() {
        List<String> list = Arrays.asList("a1a2衬衫a", "b3b4b", "c5c6c7c");
        Stream<Stream<Character>> streamStream = list.stream().map(c -> {
            char[] chars = c.toCharArray();
            List<Character> characters = new ArrayList<>();
            for (char aChar : chars) {
                characters.add(aChar);
            }
            return characters.stream();
        });
        streamStream.forEach(e -> e.forEach(System.out::println));

    }


    @Test
    public void fun5() {
        List<String> list = Arrays.asList("a1a2衬衫a", "b3b4b", "c5c6c7c");
        Stream<Character> characterStream = list.stream().flatMap(e -> {
            char[] chars = e.toCharArray();
            List<Character> characters = new ArrayList<>();
            for (char aChar : chars) {
                characters.add(aChar);
            }
            return characters.stream();
        });
        characterStream.forEach(System.out::println);

    }

    /**
     * 排序
     */
    @Test
    public void fun6() {
        employees.stream().distinct().sorted((e1, e2) -> e1.getAge().compareTo(e2.getAge())).forEach(System.out::println);
    }

    //终止操作

    @Test
    public void fun7() {
        List<Employee> employeeList = employees.stream().distinct().sorted((e1, e2) -> e1.getAge().compareTo(e2.getAge())).collect(Collectors.toList());
        System.out.println("employeeList = " + employeeList);


    }

    @Test
    public void fun8() {

        employees.stream().map((employee -> {
            return employee.getName().equals("张三");
        })).forEach(System.out::println);

    }


}
