package com.chinaedu.springcloud.service;

import com.chinaedu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: PaymentService
 * @Author: Justin
 * @Description:
 * @Date: 18:34 2020/7/3
 * @Version: 1.0
 */
public interface PaymentService {
    public int addpayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> findAll();

    public int delete(@Param("id") Long id);
}
