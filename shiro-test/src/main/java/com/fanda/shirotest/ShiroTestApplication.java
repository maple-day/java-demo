package com.fanda.shirotest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.fanda.shirotest.dao")
public class ShiroTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroTestApplication.class, args);
    }

}

