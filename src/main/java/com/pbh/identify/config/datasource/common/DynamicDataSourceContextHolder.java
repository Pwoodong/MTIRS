package com.pbh.identify.config.datasource.common;

import lombok.extern.slf4j.Slf4j;

/**
 * Package com.jiu.demo.config.datasource.common
 * ClassName DynamicDataSourceContextHolder.java
 * Description 动态数据源切换类
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2020-11-23
 **/
@Slf4j
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DataSourceKey> currentDatesource = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatesource.remove();
    }

    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static DataSourceKey get() {
        return currentDatesource.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void set(DataSourceKey value) {
        currentDatesource.set(value);
    }

    /**
     * 设置从从库读取数据
     */
    public static void setSlave() {
        DynamicDataSourceContextHolder.set(DataSourceKey.DB_MYSQL);
    }
}
