package com.pbh.identify.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Package com.pbh.identify.dao
 * ClassName IdentifyDao.java
 * Description 数据接口
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-26 下午10:36
 **/
public interface IdentifyDao {

    Collection<Map<String, Object>> insertCollection(List<Map<String,Object>> list) throws Exception;

}
