package com.chinaedu.springcloud.controller;

import com.chinaedu.springcloud.entity.Payment;
import com.chinaedu.springcloud.lb.LoadBalancer;
import com.chinaedu.springcloud.results.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: OrderController
 * @Author: Justin
 * @Description:
 * @Date: 10:19 2020/7/5
 * @Version: 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    //private static final String PAYMETN_URL = "http://localhost:8001";
    private static final String PAYMETN_URL ="http://microservice-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/consumer/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Payment> create(Payment payment){
        return  restTemplate.postForObject(PAYMETN_URL+"payment/create",payment,CommonResult.class);
    }

    @RequestMapping(value = "/consumer/getPaymentById",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMETN_URL+"payment/getPaymentById"+id,CommonResult.class);
    }

    @RequestMapping(value = "/consumer/getPaymentById2",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> responseEntity  = restTemplate.getForEntity(PAYMETN_URL+"payment/getPaymentById"+id,CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return  responseEntity.getBody();
        }else{
            return  new CommonResult<>(444,"操作失败");
        }

    }


    @RequestMapping(value = "/consumer/findAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Payment> findAll(){
        return  restTemplate.getForObject(PAYMETN_URL+"payment/findAll",CommonResult.class);
    }

    @RequestMapping("/consumer/lb")
    public String getPaymentLB(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("microservice-payment-service");
        if (null == serviceInstanceList || serviceInstanceList.size() <= 0){
             return  null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(serviceInstanceList);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"payment/lb",String.class);
    }


    @RequestMapping("/consumer/pz")
    public String paymentZipkin(){
        return  restTemplate.getForObject(PAYMETN_URL+"payment/pz",String.class);
    }
}
