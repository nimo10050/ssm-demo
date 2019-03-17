package com.nimo.controller;


import com.nimo.mq.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class IndexController {


    @Autowired
    private MessageProducer messageProducer;

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

    @RequestMapping("/mq")
    public String mq(){
        try {
            String msg = "hello";
            System.out.println("send message---->: "+ msg);
            messageProducer.sendMessage(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "hello";
    }
}
