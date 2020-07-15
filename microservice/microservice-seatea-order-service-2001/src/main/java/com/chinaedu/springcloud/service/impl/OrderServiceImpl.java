package com.chinaedu.springcloud.service.impl;

import com.chinaedu.springcloud.dao.OrderDao;
import com.chinaedu.springcloud.domain.Order;
import com.chinaedu.springcloud.service.AccountService;
import com.chinaedu.springcloud.service.OrderService;
import com.chinaedu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service.impl
 * @ClassName: OrderServiceImpl
 * @Author: Justin
 * @Description:
 * 创建订单-->调用库存服务扣减库存-->调用账户服务扣减账户余额--->修改订单状态
 *
 * @Date: 13:57 2020/7/9
 * @Version: 1.0
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "justin-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        //下订单
        System.out.println("新建订单");
        this.orderDao.create(order);
        //扣除库存
        System.out.println("订单微服务调用库存服务扣减库存量");
        this.storageService.decrease(order.getProductId(),order.getCounts());
        //扣除预额
        System.out.println("订单微服务调用账户余额扣减");
        this.accountService.decrease(order.getUserId(),order.getMoney());
        //修改订单状态
        this.orderDao.update(order.getUserId(),0);
        System.out.println("----->下订单结束");
    }
}
