package com.pbh.identify.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 * Package com.pbh.collect.service
 * ClassName OcrService.java
 * Description 图像识别接口
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-11 15:21
 **/
public interface OcrService {

    /**
     * 获取图片信息
     * @param    file   图片文件
     * @return   String
     * @throws   Exception
     **/
    String takePictureInformation(File file) throws Exception;

}
