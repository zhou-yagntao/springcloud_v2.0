package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.dao
 * @ClassName: StorageDao
 * @Author: Justin
 * @Description:
 * @Date: 11:48 2020/7/9
 * @Version: 1.0
 */
@Mapper
public interface StorageDao {

   public void update(@Param("productId") Long productID,@Param("count") Integer count);
}
