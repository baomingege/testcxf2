package com.cc.testcxf2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cc.testcxf2")
public class Testcxf2Application {
    public static void main(String[] args){
        SpringApplication.run(Testcxf2Application.class, args);
    }
}
