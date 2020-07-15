package service.impl;


import dao.StorageDao;

import org.springframework.stereotype.Service;
import service.StorageService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service.impl
 * @ClassName: StorageServiceImpl
 * @Author: Justin
 * @Description:
 * 创建订单-->调用库存服务扣减库存-->调用账户服务扣减账户余额--->修改订单状态
 *
 * @Date: 13:57 2020/7/9
 * @Version: 1.0
 */
@Service("storageService")
public class StorageServiceImpl implements StorageService {

   @Resource
   private  StorageDao storageDao;

    @Override
    public void update(Long used, BigDecimal residue) {
        this.storageDao.update(used,residue);
    }
}
