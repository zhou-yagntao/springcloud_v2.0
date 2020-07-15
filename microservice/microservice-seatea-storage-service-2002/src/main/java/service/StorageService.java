package service;


import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.service
 * @ClassName: StorageService
 * @Author: Justin
 * @Description:
 * @Date: 13:59 2020/7/9
 * @Version: 1.0
 */


public interface StorageService {

    public void update(@Param("used") Long used, @Param(" residue")BigDecimal residue);
}
