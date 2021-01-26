package com.pbh.identify.service.impl;

import com.pbh.identify.service.OcrService;
import com.pbh.identify.utils.AipImageClassifyUtils;
import com.pbh.identify.utils.ImageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

/**
 * Package com.pbh.collect.service.impl
 * ClassName OcrServiceImpl.java
 * Description 图像识别接口实现
 *
 * @author Liaoyj
 * @version V1.0
 * @date 2021-01-11 15:21
 **/
@Slf4j
@Service
public class OcrServiceImpl implements OcrService {

    /**
     * appId
     */
    private String appId = "15116711";

    /**
     * apiKey
     */
    public String apiKey = "DqMGIAK0rAjcPAM6mCKYSMHX";
    /**
     * secretKey
     */
    public String secretKey = "xmdY0B92GVG4xyjzPxxA1Rr5jgGBqsd5";

    /**
     * @see OcrService#takePictureInformation(File)
     */
    @Override
    public String takePictureInformation(File file) throws Exception {
        return ocrAipImage(file);
    }

    private String ocrAipImage(File file) throws Exception {
        AipImageClassifyUtils client = new AipImageClassifyUtils(appId, apiKey, secretKey);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        FileInputStream inputStream = new FileInputStream(file);
        String base64Content = ImageUtils.getImageStr(inputStream);
        org.json.JSONObject res = client.plantDetect(base64Content, new HashMap<String, String>());
        if (org.springframework.util.StringUtils.isEmpty(res)) {
            return "";
        }
        if (!res.has("words_result")) {
            return "";
        }
        System.out.println(res.toString());
        return res.get("words_result").toString();
    }

}
