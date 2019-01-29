package com.fangda.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Classname LambdaDemo
 * @Description TODO
 * @Date 2019/1/23 9:33
 */
public class LambdaDemo {

    public List<Employee> employees = Arrays.asList(
            new Employee(18, "张三", 1996.66),
            new Employee(28, "李四", 9996.66),
            new Employee(58, "王五", 5996.66),
            new Employee(35, "赵六", 6444.66),
            new Employee(35, "赵六", 6444.66),
            new Employee(35, "赵六", 6444.66),
            new Employee(60, "田七", 19996.66)
    );

    /**
     *  * java内置四大函数式接口
     *  *
     *  * Consumer<T> :消费型接口
     *  *          void accept(T t);
     *  *
     *  * Supplier<T> :供给型接口
     *  *          T get();
     *  *
     *  * Function<T,R> :函数型接口
     *  *          R apply(T t);
     *  *
     *  * Predicate<T> :断言型接口
     *  *          boolean test(T t);
     *  *
     */

    /**
     * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”（可以理解为方法引用时Lambda表达式的另一种表现形式）
     *  *
     *  * 主要有三种语法格式：
     *  * 对象::实例方法名
     *  * 类::静态方法名
     *  * 类::实例方法名
     *  *
     *  * 注意：
     *  * 1、Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
     *  * 2、若Lambda参数列表中的第一个参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
     *  *
     *  *
     *  * 二、构造器引用:
     *  * 格式：
     *  * ClassName::new
     *  *
     *  * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
     *  *
     *  *
     *  * 三：数组引用：
     *  *  Type::new;
     */

    @Test
    public void fun() {
        employees.stream().filter((e) -> e.getAge() > 30).map((e) -> e.getName()).forEach(System.out::println);
        System.out.println(" ============================================ ");
        employees.stream().filter((e) -> e.getAge() > 30).map(new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        }).forEach(System.out::println);
        System.out.println(" ============================================ ");
        ArrayList<String> collect = employees.stream().filter((e) -> e.getAge() > 30).map((e) -> e.getName()).collect(Collectors.toCollection(ArrayList::new));
        collect.forEach(s -> System.out.println("s = " + s));

    }

    @Test
    public void fun1() {
        Employee employee = new Employee();
        Supplier<String> getName1 = employee::getName;

        Function<Employee, String> getName = Employee::getName;
        System.out.println("name = " + getName.apply(new Employee(89, "sj", 886.66)));
        Runnable runnable = Employee::new;
        System.out.println(runnable);
    }


    @Test
    public void fun2() {
        Employee employee = new Employee();
        Supplier<Integer> getAge = employee::getAge;
        Integer integer = getAge.get();
        System.out.println("integer = " + integer);
    }

    @Test
    public void fun3() {
        employees.stream().filter((e) -> e.getAge() > 30).map((e) -> e.getName()).limit(2).forEach(System.out::println);
        System.out.println(" ========================================= ");
        employees.stream().filter((e) -> e.getAge() > 30).map(Employee::getName).limit(2).forEach(System.out::println);
    }

    @Test
    public void fun4() {
        Comparator<Integer> handler = (x, y) -> Integer.compare(x, y);
        int compare = handler.compare(2, 3);
        System.out.println("compare = " + compare);

        Comparator<Integer> compare1 = Integer::compare;
        int compare2 = compare1.compare(6, 5);
        System.out.println("compare2 = " + compare2);


    }

    @Test
    public void fun5() {
        BiFunction<Integer, Object, Boolean> biFunction = Integer::equals;
        Boolean apply = biFunction.apply(1, 1);
        System.out.println("apply = " + apply);

    }

    @Test
    public void fun6() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路！");
                    return e.getSalary() > 5000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void fun7() {
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .skip(2) //跳过前两个
                .distinct()//去重，注意：需要Employee重写hashCode 和 equals 方法
                .forEach(System.out::println);
    }

}
