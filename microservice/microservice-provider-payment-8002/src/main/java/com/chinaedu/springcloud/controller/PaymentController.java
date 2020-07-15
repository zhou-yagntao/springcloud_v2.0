package com.chinaedu.springcloud.controller;

import com.chinaedu.springcloud.entity.Payment;
import com.chinaedu.springcloud.results.CommonResult;
import com.chinaedu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: PaymentController
 * @Author: Justin
 * @Description:
 * @Date: 18:42 2020/7/3
 * @Version: 1.0
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //拿到该服务的端口号
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;  //服务发现client端

    @PostMapping(value = "/create")
    public CommonResult create(Payment payment){
        int result = this.paymentService.addpayment(payment);
        if (result > 0 ){
            return  new CommonResult(200,"插入数据库成功！serverPort："+serverPort,result);
        }else{
            return  new CommonResult(444,"插入数据库失败！serverPort："+serverPort,null);
        }
    }


    @RequestMapping(value = "/getPaymentById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  getPaymentById(@PathVariable("id") Long id){
        Payment payment = this.paymentService.getPaymentById(id);
        System.out.println("插入接口"+payment);
        if (null != payment ){
            return  new CommonResult(200,"根据id查询数据成功！serverPort："+serverPort,payment);
        }else{
            return  new CommonResult(444,"根据id查询数据失败!编号为："+id,null);
        }
    }


    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  findAll(){
        List <Payment> paymentList = this.paymentService.findAll();
        System.out.println("插入接口"+paymentList);
        if (null != paymentList ){
            return  new CommonResult(200,"查询数据成功！serverPort："+serverPort,paymentList);
        }else{
            return  new CommonResult(444,"未查询到数据：serverPort："+serverPort,null);
        }
    }

    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    @ResponseBody
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        for (String element : list) {
            System.out.println(element);
        }
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("MICROSERVICE-PAYMENT-SERVICE");
        for (ServiceInstance instance:serviceInstanceList){
            System.out.println(instance.getInstanceId()+""+instance.getPort()+""+instance.getUri());
        }
        return  this.discoveryClient;
    }

    @RequestMapping("/lb")
    public String getPaymentLB(){
        return  serverPort;
    }
}
