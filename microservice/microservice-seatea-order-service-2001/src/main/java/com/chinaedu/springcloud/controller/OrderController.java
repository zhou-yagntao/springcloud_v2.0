package com.chinaedu.springcloud.controller;

import com.chinaedu.springcloud.domain.Order;
import com.chinaedu.springcloud.results.CommonResult;
import com.chinaedu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.controller
 * @ClassName: OrderController
 * @Author: Justin
 * @Description:
 * @Date: 14:21 2020/7/9
 * @Version: 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    @ResponseBody
    public CommonResult create(Order order){
        this.orderService.create(order);
        return  new CommonResult(200,"订单创建成功");
    }

}
