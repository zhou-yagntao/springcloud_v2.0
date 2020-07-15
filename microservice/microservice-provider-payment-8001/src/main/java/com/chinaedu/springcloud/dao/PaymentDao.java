package com.chinaedu.springcloud.dao;

import com.chinaedu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud
 * @ClassName: PaymentDao
 * @Author: Justin
 * @Description:
 * @Date: 18:16 2020/7/3
 * @Version: 1.0
 */
@Mapper
public interface PaymentDao {

    public int addpayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> findAll();

    public int delete(@Param("id") Long id);

}
