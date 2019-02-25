package com.nimo.controller;


import com.nimo.entity.TbUser;
import com.nimo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, List<TbUser>> redisTemplate;

    @RequestMapping("/list")
    @ResponseBody
    public List<TbUser> list(){

        List<TbUser> userList = redisTemplate.opsForValue().get("userList");
        if (userList == null){
            userList = userService.list();
            redisTemplate.opsForValue().set("userList", userList, 60, TimeUnit.SECONDS);// 一分钟过期时间
            System.out.println("从数据库里面取出数据....");
        }else{
            System.out.println("从缓存中取数据...");
        }

        return userList;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(){


        try {
            userService.save();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //redisTemplate.boundHashOps("").

        return "success";
    }

}
