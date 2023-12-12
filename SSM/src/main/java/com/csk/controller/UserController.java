package com.csk.controller;

import com.csk.pojo.Users;
import com.csk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private ApplicationContext applicationContext;

    UserService userService = applicationContext.getBean(UserService.class);

    @RequestMapping("/")
    public String index(){
        System.out.println("执行index");
        return "index";
    }
    @RequestMapping("/userQuery")
    public String userQ(){
        System.out.println("请求userQuery");
        return "userQuery";
    }

    @RequestMapping(value = "/userQuery/userQueryAll",method = RequestMethod.GET)
    public String userQueryAll(Model model){
//        UserService userService = new UserService();
        Users users = new Users();
        List<Users> list = userService.getUserList(users);
        model.addAttribute("user",list);
        return "userall";
    }

    @RequestMapping(value = "/userAdd",method = RequestMethod.GET)
    public String userAdd(){
        return "userAdd";
    }
    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public String user(@RequestParam("user_name") String username,@RequestParam("password") String password){
        if (userService.findByUsername(username)==null){
            Users user = new Users();
            user.setUser_name(username);
            user.setPassword(password);
            userService.addUser(user);
            return "redirect:/";
        }else {
            return "redirect:/userAdd";
        }
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    public String delUser(){
        return "delUser";
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public String del(@RequestParam("id") String id){
        userService.delUser(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/updataUser", method = RequestMethod.GET)
    public String updataU(){return "updataUser";}
    @RequestMapping(value = "/updataUser", method = RequestMethod.POST)
    public String updataUser(@RequestParam("id") String id, @RequestParam("user_name")String username, @RequestParam("password") String password){
        Users users = new Users();
        users.setId(Integer.valueOf(id));
        users.setUser_name(username);
        users.setPassword(password);
        userService.updataUser(users);
        return "redirect:/";
    }

}
