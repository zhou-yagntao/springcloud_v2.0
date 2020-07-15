package config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.activation.DataSource;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.config
 * @ClassName: DataSourceProxyConfig
 * @Author: Justin
 * @Description:
 * @Date: 14:26 2020/7/9
 * @Version: 1.0
 */
@Configuration
public class DataSourceProxyConfig {

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return (DataSource) new DruidDataSource();
    }

   @Bean
   public DataSourceProxy dataSourceProxy(DataSource dataSource){
        return  new DataSourceProxy((javax.sql.DataSource) dataSource);
   }

    @Bean
    public SqlSessionFactory SqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
     SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
     sqlSessionFactoryBean.setDataSource(dataSourceProxy);
     sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
     sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
     return sqlSessionFactoryBean.getObject();
    }

}

