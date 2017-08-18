package com.blackunion.george.plum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by George on 2017-07-17.
 */
@Controller
public class LoginController  {


    @RequestMapping(value = "/login")
    @ResponseBody
    public String index(){
        return "login";
    }
}
