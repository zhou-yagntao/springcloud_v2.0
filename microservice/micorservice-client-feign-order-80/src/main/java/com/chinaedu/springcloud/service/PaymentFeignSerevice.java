package com.chinaedu.springcloud.service;

import com.chinaedu.springcloud.entity.Payment;
import com.chinaedu.springcloud.results.CommonResult;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: PaymentFeignSerevice
 * @Author: Justin
 * @Description:
 * @Date: 18:21 2020/7/5
 * @Version: 1.0
 */
@Component
@FeignClient(value = "MICSERVICE-PAYMENT-SERVICE")
public interface PaymentFeignSerevice {

    @RequestMapping(value = "/getPaymentById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  getPaymentById(@PathVariable("id") Long id);

}
