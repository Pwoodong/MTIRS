package com.pbh.identify.config.datasource.annotation;

import com.pbh.identify.config.datasource.common.DataSourceKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package com.jiu.demo.config.datasource.annotation
 * ClassName TargetDataSource.java
 * Description 数据源注解
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2020-11-23
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    DataSourceKey dataSourceKey() default DataSourceKey.DB_MONGO;
}
