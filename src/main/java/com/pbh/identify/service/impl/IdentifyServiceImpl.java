package com.pbh.identify.service.impl;

import com.pbh.identify.dao.IdentifyDao;
import com.pbh.identify.mapper.RunnerOnlineMapper;
import com.pbh.identify.service.IdentifyService;
import com.pbh.identify.service.OcrService;
import com.pbh.identify.utils.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

/**
 * Package com.pbh.identify.service.impl
 * ClassName SimpleMongoServiceImpl.java
 * Description 运动轨迹图像识别统计接口实现
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-26 13:53
 **/
@Slf4j
@Service
public class IdentifyServiceImpl implements IdentifyService {

    @Autowired
    private OcrService ocrService;

    @Autowired
    private IdentifyDao identifyDao;

    @Autowired
    private RunnerOnlineMapper runnerOnlineMapper;

    /**
     * @see IdentifyService#upload(MultipartFile)
     */
    @Override
    public int upload(MultipartFile file){
        int count = 1;
        try {
            String destDirPath = "/Users/jiu/data/test/temp";
            File newFile = ZipUtil.multipartFileToFile(file);
            ZipUtil.unzipFile(newFile,destDirPath);

            File destDir = new File(destDirPath);
            File[] files = destDir.listFiles();
            List<Map<String,Object>> list = new ArrayList<>();
            for(File f:files){
                Map<String,Object> map = new HashMap<>();
                map.put("fileName",f.getName());
                String resultMap = ocrService.takePictureInformation(f);
                log.info(f.getName()+"文件内容【"+ resultMap+"】");
                map.put("content",resultMap);
                list.add(map);
            }
            ZipUtil.deletefile(destDirPath);
            Collection<Map<String, Object>> collection =  identifyDao.insertCollection(list);
            log.info("mongo result :" + collection.size());
        } catch (Exception e) {
            log.error("上传图片文件识别出现异常."+e.getMessage());
        }
        return count;
    }

    @Override
    public void getData() {
        try {
            List<Map> result = identifyDao.selectCollection();
            System.out.println(result);
            List<Map<String,Object>> runnerList = runnerOnlineMapper.selectRunnerOnline();
            System.out.println(runnerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
