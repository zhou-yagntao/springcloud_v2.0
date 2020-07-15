package com.chinaedu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: PaymentController
 * @Author: Justin
 * @Description:
 * @Date: 14:22 2020/7/5
 * @Version: 1.0
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/consul")
    @ResponseBody
    private String paymentConsul(){
        return  "springcloud with consul:"+serverPort+ UUID.randomUUID().toString();
    }
}
