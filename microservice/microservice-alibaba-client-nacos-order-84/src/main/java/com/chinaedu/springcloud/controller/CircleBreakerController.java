package com.chinaedu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chinaedu.springcloud.entity.Payment;
import com.chinaedu.springcloud.results.CommonResult;
import com.chinaedu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: CircleBreakerController
 * @Author: Justin
 * @Description:
 * @Date: 20:25 2020/7/8
 * @Version: 1.0
 */
@Controller
@RequestMapping("/circleBreaker")
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;
    //之前写法
    //private static  String NACOS_PAYMENT_URI = "http:////nacos-payment-provider";
    //修改之后使用配置文件编写
    @Value("${service-url.nacos-user.service}")
    private String serverUrl;

    @RequestMapping("/comsumer/fallback/{id}")
    //@SentinelResource(value = "fallback") //未作配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallBack") //fallback处理业务类
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //只负责sentinel控制台异常配置
    @SentinelResource(value = "fallback",
                      blockHandler = "blockHandler",
                      fallback = "handlerFallBack",
                      exceptionsToIgnore = IllegalArgumentException.class)
    public CommonResult fallBack(@PathVariable("id") Integer id) throws IllegalAccessException {

        CommonResult result = restTemplate.getForObject(serverUrl+"/payment/{id}/"+id,CommonResult.class,id);
        if (id < 0){
            throw  new IllegalAccessException("IllegalAccessException,非法参数异常");
        }else if(null == result){
            throw new NullPointerException("NullPointerException,空指针异常");
        }
        return  result;
    }

    public CommonResult  handlerFallBack(@PathVariable("id") Long id,Throwable throwable){
        return  new CommonResult(444,"兜底异常"+throwable.getMessage());
    }

    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException blockException){
        return  new CommonResult(445,"兜底异常"+blockException.getMessage());
    }

    //===============openfeign=====================

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/comsumer/fallback/{id}")
    @ResponseBody
    public String fallBack1(@PathVariable("id") Integer id) throws IllegalAccessException {
       return  this.paymentService.getPayment(id);
    }


}
