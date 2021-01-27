package com.pbh.identify.config.datasource.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Package com.jiu.demo.config.datasource.common
 * ClassName DynamicRoutingDataSource.java
 * Description 动态数据源路由类
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2020-11-23
 **/
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("当前数据源：{}"+ DynamicDataSourceContextHolder.get());
        return DynamicDataSourceContextHolder.get();
    }
}
