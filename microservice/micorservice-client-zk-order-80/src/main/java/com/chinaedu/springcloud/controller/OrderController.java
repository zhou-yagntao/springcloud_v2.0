package com.chinaedu.springcloud.controller;

import com.chinaedu.springcloud.entity.Payment;
import com.chinaedu.springcloud.results.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud
 * @ClassName: OrderController
 * @Author: Justin
 * @Description:
 * @Date: 10:32 2020/7/5
 * @Version: 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    //private static final String PAYMETN_URL = "http://localhost:8001";
    private static final String PAYMETN_URL ="http://microservice-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consume/payment",method = RequestMethod.GET)
    @ResponseBody
    public String payment(){
        return  restTemplate.getForObject(PAYMETN_URL+"payment/zk",String.class);
    }
}
