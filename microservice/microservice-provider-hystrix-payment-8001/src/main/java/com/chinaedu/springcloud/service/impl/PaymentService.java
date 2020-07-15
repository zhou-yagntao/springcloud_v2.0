package com.chinaedu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.chinaedu.springcloud.service.PaymentServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Paper;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: PaymentService
 * @Author: Justin
 * @Description:
 * @Date: 20:07 2020/7/5
 * @Version: 1.0
 */

@Service
public class PaymentService  implements PaymentServiceImpl {

    /*
    * 正常访问
    * */
    @Override
    public String paymentInfo_OK(Integer id){
        return  "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id"+"id"+"耗时5秒钟";
    }

    /*
     * =============================服务降级==============================================
     * */

    //该方法出现问题，找paymentInfo_TimeOutHandler处理
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    }) //正常情况为3s，超过3s出错就去找paymentInfo_TimeOutHandler进行兜底
    @Override
    public String paymentInfo_Timeout(){
        //int timeNumber = 3;
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "线程池："+Thread.currentThread().getName()+"paymentInfo_Timeout,id"+"id"+"√";
    }


    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,系统繁忙，稍后再试,id"+id+"o(╥﹏╥)o";
    }

    /*
    * =============================服务熔断==============================================
    * */

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0 ){
            throw  new RuntimeException("id不可以为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return  Thread.currentThread().getName()+"调用成功，流水号id:"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return  "id不能为负数,o(╥﹏╥)o";
    }

}
