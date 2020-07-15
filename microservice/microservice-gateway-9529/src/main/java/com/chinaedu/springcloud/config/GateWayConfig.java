package com.chinaedu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.config
 * @ClassName: GateWayConfig
 * @Author: Justin
 * @Description:
 * @Date: 18:22 2020/7/6
 * @Version: 1.0
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
       RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
       routes.route("path_route_justin",r->r.path("/guonei")
                                                .uri("http://news.baidu.com/guinei")).build();
       return  routes.build();
    }

}
