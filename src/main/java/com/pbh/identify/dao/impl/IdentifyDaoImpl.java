package com.pbh.identify.dao.impl;

import com.pbh.identify.dao.IdentifyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Package com.pbh.identify.dao.impl
 * ClassName IdentifyDaoImpl.java
 * Description 数据接口实现
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-26 下午10:37
 **/
@Repository
public class IdentifyDaoImpl implements IdentifyDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Collection<Map<String, Object>> insertCollection(List<Map<String,Object>> list) throws Exception{
        return mongoTemplate.insert(list,Map.class);
    }

}
