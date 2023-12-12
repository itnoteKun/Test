package com.csk.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/test")
    public String hello(){
        //这里的访问路径是http://localhost:8888/hello/test

//        modelMap.addAttribute("message","Hello csk!");
        return "hello";
    }
}
