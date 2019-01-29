package com.fangda.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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


}
