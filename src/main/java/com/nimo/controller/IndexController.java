package com.nimo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class IndexController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        System.out.println("index...");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){

        return "hello";
    }

}
