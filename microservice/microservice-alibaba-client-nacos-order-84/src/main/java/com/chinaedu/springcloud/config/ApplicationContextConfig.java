package com.chinaedu.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.config
 * @ClassName: ApplicationContextConfig
 * @Author: Justin
 * @Description:
 * @Date: 8:03 2020/7/8
 * @Version: 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
