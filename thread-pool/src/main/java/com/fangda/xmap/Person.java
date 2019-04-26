package com.fangda.xmap;


public class Person {

    private Integer age;
    private String username;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
