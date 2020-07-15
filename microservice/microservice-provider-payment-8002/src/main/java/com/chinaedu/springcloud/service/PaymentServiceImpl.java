package com.chinaedu.springcloud.service;

import com.chinaedu.springcloud.dao.PaymentDao;
import com.chinaedu.springcloud.entity.Payment;
import com.chinaedu.springcloud.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service.impl
 * @ClassName: PaymentServiceImpl
 * @Author: Justin
 * @Description:
 * @Date: 18:34 2020/7/3
 * @Version: 1.0
 */
@Service("paymentService")
public class PaymentServiceImpl  implements PaymentService {

    @Autowired  //spring中的注解   @resource java自带的 也可实现依赖注入
    private PaymentDao paymentDao;

    @Override
    public int addpayment(Payment payment) {
        return this.paymentDao.addpayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return this.paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> findAll() {
        return this.paymentDao.findAll();
    }

    @Override
    public int delete(Long id) {
        return this.paymentDao.delete(id);
    }
}
