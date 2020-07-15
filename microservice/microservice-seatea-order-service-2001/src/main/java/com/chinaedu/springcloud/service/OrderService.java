package com.chinaedu.springcloud.service;

import com.chinaedu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: OrderServiceImpl
 * @Author: Justin
 * @Description:
 * @Date: 12:03 2020/7/9
 * @Version: 1.0
 */
public interface OrderService {

    public void create(Order order);

}
