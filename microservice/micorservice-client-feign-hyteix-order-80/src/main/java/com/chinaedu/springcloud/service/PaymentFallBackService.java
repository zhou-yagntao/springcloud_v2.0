package com.chinaedu.springcloud.service;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: PaymentFallBackService
 * @Author: Justin
 * @Description: 异常处理
 * @Date: 10:59 2020/7/6
 * @Version: 1.0
 */
@Component
public class PaymentFallBackService  implements  PaymentHystrixOpenFeignService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentHystrixOpenFeignService_paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout() {
        return "----PaymentHystrixOpenFeignService_paymentInfo_Timeout,o(╥﹏╥)o";
    }
}
