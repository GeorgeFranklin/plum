package com.blackunion.george.plum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 程序运行入口。
 * Created by George on 2017-08-08.
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {

        log.info("##**=========== 开始启动 =============**##");
        SpringApplication.run(Application.class, args);
        log.info("##**=========== 项目启动完成 =============**##");
    }
}
