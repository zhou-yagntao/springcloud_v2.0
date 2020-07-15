package com.chinaedu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //回路
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }


    /*
    * 以下配置是为了服务监控而配置，与服务容错本身没有关系。springcloud升级后的小bug
    * serverRegistrationBean因为springboot的默认路径不是“/hystrix.stream”
    * 只要在自己的项目添加以下servlet
    * */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return  registrationBean;
    }

}
