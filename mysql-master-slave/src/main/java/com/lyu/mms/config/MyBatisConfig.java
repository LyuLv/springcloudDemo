package com.lyu.mms.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Author: Lyu
 * @Description: 由于Spring容器中现在有3个数据源，所以我们需要为事务管理器和MyBatis手动指定一个明确的数据源。
 * @Date: Created in 17:32 2020/12/29
 * @Modified By:
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig {

    @Resource(name = "DBSource")
    private DataSource routingDataSource;

    /**
     * SqlSessionFactory的数据源
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(routingDataSource);
        //可能出错的问题：sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath))，写错成了getResource导致找不到classpath:mapper/*.xml的错误
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 设置事务
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(routingDataSource);
    }

}
