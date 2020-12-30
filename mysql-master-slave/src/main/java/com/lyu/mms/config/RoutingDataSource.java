package com.lyu.mms.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 17:05 2020/12/29
 * @Modified By:
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
