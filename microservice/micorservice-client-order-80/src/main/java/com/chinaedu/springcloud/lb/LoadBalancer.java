package com.chinaedu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.lb
 * @ClassName: LoadBalancer
 * @Author: Justin
 * @Description: 容器加载接口
 * @Date: 16:57 2020/7/5
 * @Version: 1.0
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
