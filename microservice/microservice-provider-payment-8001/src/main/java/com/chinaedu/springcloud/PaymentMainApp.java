package com.chinaedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMainApp
{
    public static void main( String[] args){
        SpringApplication.run(PaymentMainApp.class,args);
    }
}
