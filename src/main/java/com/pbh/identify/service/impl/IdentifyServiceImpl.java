package com.pbh.identify.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbh.identify.dao.IdentifyDao;
import com.pbh.identify.entity.RunnerOnline;
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
            List<Map> collectionList = identifyDao.selectCollection();
            List<RunnerOnline> runnerList = runnerOnlineMapper.selectRunnerOnline();
            System.out.println(runnerList);
            for(Map map:collectionList){
                for(RunnerOnline runnerOnline : runnerList){
                    String content = map.get("content").toString();
                    ObjectMapper mapper = new ObjectMapper();
                    List<Map> lst = mapper.readValue(content, new TypeReference<List<Map>>() {});
                    boolean flag = false;
                    for(int i = 0; i < lst.size();i++){
                        Map lMap = lst.get(i);
                        if(runnerOnline.getNick().equals(lMap.get("words").toString().trim())){
                            System.out.println(runnerOnline.getNick() +","+ lMap.get("words"));
                            flag = true;
                        }
                    }
                    if(flag){
                        for(int i = 0; i < lst.size();i++){
                            Map lMap = lst.get(i);
                            if(lMap.get("words").toString().trim().indexOf(runnerOnline.getKeyword2()) != -1){
                                int index = Integer.valueOf(runnerOnline.getKeyword2index());
                                System.out.println(runnerOnline.getKeyword2() + ":" + lst.get(i-index).get("words"));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
