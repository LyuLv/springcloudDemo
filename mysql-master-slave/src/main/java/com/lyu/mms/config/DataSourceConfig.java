package com.lyu.mms.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 16:20 2020/12/29
 * @Modified By:
 */
@Configuration
public class DataSourceConfig {

    /**
     * 主库数据源
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 从库数据源
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slave() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 路由数据源
     * @param master
     * @param slave
     * @return
     */
    @Bean(name = "DBSource")
    public DataSource dataSourceRoutingDb(@Qualifier("master") DataSource master,
                                          @Qualifier("slave") DataSource slave) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DBTypeEnum.MASTER, master());
        targetDataSource.put(DBTypeEnum.SLAVE, slave());
        RoutingDataSource dataSourceRoutingDb = new RoutingDataSource();
        dataSourceRoutingDb.setDefaultTargetDataSource(master);
        dataSourceRoutingDb.setTargetDataSources(targetDataSource);

        return dataSourceRoutingDb;
    }


}
