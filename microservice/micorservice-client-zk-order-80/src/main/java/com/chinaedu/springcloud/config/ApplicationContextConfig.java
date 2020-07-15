package com.chinaedu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.config
 * @ClassName: ApplicationContextConfig
 * @Author: Justin
 * @Description:
 * @Date: 10:29 2020/7/5
 * @Version: 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplete(){
        return  new RestTemplate();
    }

}
