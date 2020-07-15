package com.chinaedu.springcloud.dao;

import com.chinaedu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.dao
 * @ClassName: OrderDao
 * @Author: Justin
 * @Description:
 * @Date: 11:48 2020/7/9
 * @Version: 1.0
 */
@Mapper
public interface OrderDao {

    //新建
    public void create(Order order);

    //修改状态
    public void  update(@Param("userId") Long userID,@Param("status") Integer status);

}
