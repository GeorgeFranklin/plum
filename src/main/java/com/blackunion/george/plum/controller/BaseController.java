package com.blackunion.george.plum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制类基类。
 * Created by George on 2017-07-17.
 */
@RestController
public class BaseController {

    /**
     * 进入首页
     * @return String 页面名称
     */
    @RequestMapping("/")
    public String home() {
        System.out.println("测试");
        return "Hello World";
    }

    /**
     * 进入首页
     * @return String 页面名称
     */
    @RequestMapping("/index")
    public String index() {
        System.out.println("测试");
        return "Hello World";
    }

//    public static void main(String[] args){
//        SpringApplication.run(BaseController.class,args);
//    }


}
