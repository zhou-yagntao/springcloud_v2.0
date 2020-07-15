package com.chinaedu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.config
 * @ClassName: OpenFeignConfig
 * @Author: Justin
 * @Description:
 * @Date: 18:58 2020/7/5
 * @Version: 1.0
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
