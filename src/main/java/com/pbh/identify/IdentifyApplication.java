package com.pbh.identify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 * @author liaoyj
 **/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class IdentifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentifyApplication.class, args);
    }

}
