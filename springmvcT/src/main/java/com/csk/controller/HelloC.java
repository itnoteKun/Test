package com.csk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloC {
    @RequestMapping("/")
    public String index(){
        System.out.println("执行index函数");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("执行hello函数");
        //返回逻辑视图 逻辑视图相当于视图的别名 通过这个找到物理视图，也就是真正的视图
        //这里返回的只是页面的名称，不是完整的页面访问路径
        return "hello";
    }


}
