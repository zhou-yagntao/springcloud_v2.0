package com.chinaedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment_8005_App
{
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment_8005_App.class,args);
    }
}
