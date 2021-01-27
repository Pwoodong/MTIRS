package com.pbh.identify.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Package com.pbh.identify.service
 * ClassName SimpleMongoService.java
 * Description 运动轨迹图像识别统计接口
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-26 13:52
 **/
public interface IdentifyService {

    /**
     * 上传压缩文件
     * @param    file   图片文件
     * @return   int
     **/
    int upload(MultipartFile file);

    /**
     * 查询数据
     * @param
     * @return   void
     **/
    void getData();
}
