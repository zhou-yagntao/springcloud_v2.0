package com.chinaedu.springcloud.service;

import com.chinaedu.springcloud.results.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: PaymentFallBackService
 * @Author: Justin
 * @Description:
 * @Date: 8:50 2020/7/9
 * @Version: 1.0
 */
@Component
public class PaymentFallBackService implements PaymentService{

    @Override
    public String getPayment(Integer id) {
        return "服务降级放回-----";
    }
}
