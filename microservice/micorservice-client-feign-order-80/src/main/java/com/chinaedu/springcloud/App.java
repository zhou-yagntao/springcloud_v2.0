package com.chinaedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //激活并开启引入的注解
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
