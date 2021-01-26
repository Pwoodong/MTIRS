package com.pbh.identify.service.impl;

import com.pbh.identify.service.SimpleMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Package com.pbh.identify.service.impl
 * ClassName SimpleMongoServiceImpl.java
 * Description 简单接口实现
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-26 13:53
 **/
public class SimpleMongoServiceImpl implements SimpleMongoService {

    /**
     * 注入template，减少重复代码
     */
    @Autowired
    private MongoTemplate mongoTemplate;

}
