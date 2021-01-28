package com.pbh.identify.mapper;

import com.pbh.identify.config.datasource.annotation.TargetDataSource;
import com.pbh.identify.config.datasource.common.DataSourceKey;
import com.pbh.identify.entity.RunnerOnline;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Package com.pbh.identify.dao
 * ClassName RunnerOnline.java
 * Description
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-27 下午11:18
 **/
@Component
public interface RunnerOnlineMapper {

    /**
     * 查询数据
     * @return      List
     **/
    @TargetDataSource(dataSourceKey = DataSourceKey.DB_MYSQL)
    List<RunnerOnline> selectRunnerOnline();

}
