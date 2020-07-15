package com.chinaedu.springcloud.service;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service.impl
 * @ClassName: PaymentServiceImpl
 * @Author: Justin
 * @Description:
 * @Date: 20:28 2020/7/5
 * @Version: 1.0
 */
public interface PaymentServiceImpl {
    public String paymentInfo_OK(Integer id);
    public String paymentInfo_Timeout();
    public  String paymentCircuitBreaker(Integer id);
}
