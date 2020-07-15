package com.chinaedu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.lb
 * @ClassName: PersonLB
 * @Author: Justin
 * @Description:
 * @Date: 16:59 2020/7/5
 * @Version: 1.0
 */
@Component
public class PersonLB implements  LoadBalancer{


    //原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获得工作的服务类，使用自旋锁
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get(); //获得当前的初始值
            //2147483647表示整形数的最大值 current >= 2147483647表示当前值current是否大于2147483647  0 : current+1 表示: 满足 为0 不满足 当前值+1
            next = current >= 2147483647 ? 0 : current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));  //不满足一致循环
        System.out.println("*****第几次访问，次数"+next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index); //获得服务
    }
}
