package com.demo.zhongxin.controller;


import com.demo.zhongxin.common.R;
import com.demo.zhongxin.handler.PassToken;
import com.demo.zhongxin.service.CounterService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Api(value = "柜员", tags = "柜员操作接口")
@RequestMapping(value = "/counter")
public class CounterController{

    @Autowired
    private CounterService counterService;

    @PassToken
    @GetMapping("/login")
    public R login(String name, String password){
        return counterService.login(name,password);
    }

    @PassToken
    @RequestMapping("/test")
    public String test(){
        return "hello!";
    }
}
