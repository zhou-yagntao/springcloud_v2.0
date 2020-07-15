package com.chinaedu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: PaymentHystrixOpenFeignService
 * @Author: Justin
 * @Description:
 * @Date: 8:39 2020/7/6
 * @Version: 1.0
 */
@Component
@FeignClient(name = "MICROSERVICE-PAYMENT-SERVICE",fallbackFactory = PaymentFallBackService.class)
public interface PaymentHystrixOpenFeignService {

    @RequestMapping(value = "hystrix/ok/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @RequestMapping(value = "hystrix/timeout",method = RequestMethod.GET)
    @ResponseBody
    public String paymentInfo_Timeout();
}
