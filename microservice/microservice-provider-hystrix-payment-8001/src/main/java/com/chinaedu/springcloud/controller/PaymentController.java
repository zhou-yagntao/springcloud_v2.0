package com.chinaedu.springcloud.controller;

import com.chinaedu.springcloud.service.PaymentServiceImpl;
import com.chinaedu.springcloud.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: PaymentController
 * @Author: Justin
 * @Description:
 * @Date: 20:11 2020/7/5
 * @Version: 1.0
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    public String serverPort;


    @RequestMapping(value = "hystrix/ok/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return  this.paymentService.paymentInfo_OK(id);
    }

    @RequestMapping(value = "hystrix/timeout",method = RequestMethod.GET)
    @ResponseBody
    public String paymentInfo_Timeout(){

        return  this.paymentService.paymentInfo_Timeout();
    }


    /*
    * ==================服务熔断==============================
    * */
    @RequestMapping(value = "hystrix/circuit/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return  this.paymentService.paymentCircuitBreaker(id);
    }
}
