package com.chinaedu.springcloud.controller;

import com.chinaedu.springcloud.service.PaymentHystrixOpenFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: OrderHystrixOpenFeignController
 * @Author: Justin
 * @Description:
 * @Date: 8:41 2020/7/6
 * @Version: 1.0
 */
@Controller
@RequestMapping("/consume")
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixOpenFeignController {

    @Autowired
    private PaymentHystrixOpenFeignService paymentHystrixOpenFeignService;

    @RequestMapping(value = "/payment/hystrix/ok/{id}",method = RequestMethod.GET)
    @ResponseBody
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallBackMethod",commandProperties =
            {@HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        int num = 10/0;
        return  this.paymentHystrixOpenFeignService.paymentInfo_OK(id);
    }

   public String  paymentTimeOutFallBackMethod(Integer id){
        return  "对方支付系统繁忙或者自己异常，请10秒后再试"+"o(╥﹏╥)o";
   }



    @RequestMapping(value = "/paymenthystrix/timeout",method = RequestMethod.GET)
    @ResponseBody
    public String paymentInfo_Timeout(){
        return  this.paymentHystrixOpenFeignService.paymentInfo_Timeout();
    }


    //定义全局
    public String payment_Global_FallbackMethod(){
        return  "Global异常处理信息,请稍后再试，o(╥﹏╥)o";
    }

}
