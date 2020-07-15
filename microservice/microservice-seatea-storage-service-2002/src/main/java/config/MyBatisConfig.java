package config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.config
 * @ClassName: MyBatisConfig
 * @Author: Justin
 * @Description:
 * @Date: 14:25 2020/7/9
 * @Version: 1.0
 */
@Configuration
@MapperScan({"com.chinaedu.springcloud.dao"})
public class MyBatisConfig{}
