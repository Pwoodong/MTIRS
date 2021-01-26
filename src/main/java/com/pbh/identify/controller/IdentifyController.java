package com.pbh.identify.controller;

import com.pbh.identify.service.IdentifyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Package com.pbh.identify.controller
 * ClassName IdentifyController.java
 * Description 运动轨迹图像识别统计接口
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-26 下午8:53
 **/
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/identify")
public class IdentifyController {

    @Autowired
    private IdentifyService identifyService;

    @PostMapping("upload")
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file){
        String contentType = file.getContentType();
        identifyService.upload(file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
