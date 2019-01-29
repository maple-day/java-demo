package com.fangda.jdk8;

import java.util.Objects;

/**
 * @Classname Employee
 * @Description TODO
 * @Date 2019/1/23 9:36
 */
public class Employee {

    private Integer age;
    private String name;
    private Double salary;

    public Employee() {
    }

    public Employee(Integer age, String name, Double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(age, employee.age) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name, salary);
    }
}
