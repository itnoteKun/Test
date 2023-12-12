package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制层
 */
@Controller
@RequestMapping("/admin")  //一级映射地址
public class AdminController {
    @Autowired  //@Autowired依赖注入
    private AdminService adminService;
    //http://localhost:8080/admin/registerpage
    @RequestMapping("/registerpage")
    public String registerPage(){
        return "register";   //register是一个物理视图，对应jsp文件名称
    }
//    @ResponseBody      //添加@ResponseBody注解后，返回的是字符串,如果不添加，则返回一个页面
    @RequestMapping("/doregister")
    public String doRegister(Admin admin){
//        判断用户是否存在，不存在就保存
        Admin dbAdmin = adminService.findByName(admin.getName());
        if (dbAdmin==null){
            adminService.createAdmin(admin);
            return "redirect:loginpage";
        }else{
            return "redirect:registerpage?error=1";
        }
    }

//    http://localhost:8080/admin/loginpage
    @RequestMapping("/loginpage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/dologin")
    public String doLogin(Admin admin){
        Admin dbAdmin=adminService.findByNameAndPwd(admin);
        if(dbAdmin!=null){
            return "redirect:pricePage";//登录成功，跳转到主页
        }else {
            return "redirect:loginpage?error=1"; //登录验证失败，跳转到登录页面，并提示登录信息错误
        }
    }

    @RequestMapping("/pricePage")
    public String pricePage(){
        return "price";
    }

//    http://localhost:8080/admin/vegetablePage
    @RequestMapping("/vegetablePage")
    public String vegetablePage(){
        return "vegetable";
    }

//      http://localhost:8080/admin/dynamicPage
    @RequestMapping("/dynamicPage")
    public String dynamicPage(){
        return "dynamic";
    }


}
