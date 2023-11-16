package com.demo.zhongxin;

import com.demo.zhongxin.controller.CounterController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan(basePackages = "com.demo.zhongxin.mapper",basePackageClasses = CounterController.class)
public class ZhongxinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhongxinApplication.class, args);
    }

}
