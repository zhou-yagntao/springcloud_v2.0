package com.chinaedu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: OrderNacosController
 * @Author: Justin
 * @Description:
 * @Date: 8:05 2020/7/8
 * @Version: 1.0
 */
@Controller
@RequestMapping("/orderNacos")
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;
    //之前写法
    //private static  String NACOS_PAYMENT_URI = "http:////nacos-payment-provider";
    //修改之后使用配置文件编写
    @Value("${service-url.nacos-user.service}")
    private String serverUrl;

    @RequestMapping("/consumer/payment/{id}")
    @ResponseBody
    public String getPaymentInfo(@PathVariable("id") Long id){
        String info =  restTemplate.getForObject(serverUrl+"/payment/nacos/{id}",String.class);
        return  info;
    }

}
