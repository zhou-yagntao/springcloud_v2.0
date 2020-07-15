package com.chinaedu.springcloud.controller;

import com.chinaedu.springcloud.entity.Payment;
import com.chinaedu.springcloud.results.CommonResult;
import com.chinaedu.springcloud.service.PaymentFeignSerevice;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.Thread.sleep;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: PaymentOpenFeignController
 * @Author: Justin
 * @Description:
 * @Date: 18:27 2020/7/5
 * @Version: 1.0
 */
@Controller
@RequestMapping("/paymentOpenFeign")
public class PaymentOpenFeignController {

    @Autowired
    private PaymentFeignSerevice paymentFeignSerevice;

    @RequestMapping(value = "/consumer/getPaymentById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return  this.paymentFeignSerevice.getPaymentById(id);
    }

    public String paymentFeignTimeOUt(){

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return  null;
    }

}
