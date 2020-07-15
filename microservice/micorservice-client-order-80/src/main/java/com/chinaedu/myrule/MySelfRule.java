package com.chinaedu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.myrule
 * @ClassName: MySelfRule
 * @Author: Justin
 * @Description:自定义算法实现
 * @Date: 16:14 2020/7/5
 * @Version: 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    //@LoadBalanced
    public IRule  personRule(){
        return  new RandomRule(); //定义随机算法
    }
}
