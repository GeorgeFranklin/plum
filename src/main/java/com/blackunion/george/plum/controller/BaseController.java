package com.blackunion.george.plum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制类基类。
 * Created by George on 2017-07-17.
 */
@Controller
public class BaseController {

    /**
     * 进入首页
     * @return String 页面名称
     */
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World";
    }


}
