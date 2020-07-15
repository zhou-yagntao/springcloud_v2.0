package com.chinaedu.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.filter
 * @ClassName: PersonGlobalGateWayFilter
 * @Author: Justin
 * @Description: 自定义全局过滤器
 * @Date: 20:04 2020/7/6
 * @Version: 1.0
 */
@Component
public class PersonGlobalGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("PersonGlobalGateWayFilter"+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (null ==uname){
            System.out.println("用户名非法");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
