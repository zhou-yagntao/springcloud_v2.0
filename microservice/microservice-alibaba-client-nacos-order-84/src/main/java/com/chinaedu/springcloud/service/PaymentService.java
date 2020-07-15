package com.chinaedu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: PaymentService
 * @Author: Justin
 * @Description:
 * @Date: 8:47 2020/7/9
 * @Version: 1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallBackService.class)
public interface  PaymentService {

    @RequestMapping("/nacos/{id}")
    @ResponseBody
    public String getPayment(@PathVariable("id") Integer id);

}
