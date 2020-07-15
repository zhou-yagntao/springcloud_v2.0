package com.chinaedu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: PaymentController
 * @Author: Justin
 * @Description:
 * @Date: 20:15 2020/7/7
 * @Version: 1.0
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverport;


    @RequestMapping("/nacos/{id}")
    @ResponseBody
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos register,serverport:"+serverport+"id:"+id;
    }

}
