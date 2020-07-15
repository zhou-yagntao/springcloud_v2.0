package com.chinaedu.springcloud;

import com.chinaedu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//name ="MISROSERVICE-PAYMENT-SERVOCE" 表示要访问的微服务  configuration = MySelfRule.class  加载自己定义的算法
@RibbonClient(name ="MISROSERVICE-PAYMENT-SERVOCE",configuration = MySelfRule.class)
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
