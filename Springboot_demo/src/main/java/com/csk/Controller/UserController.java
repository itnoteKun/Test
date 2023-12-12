package com.csk.Controller;

import com.csk.service.ChatService;
import com.csk.service.UserService;
import com.csk.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author csk
 * @date 2023/11/23 20:33
 */
@Controller
public class UserController {
    private final UserService userService;
    private final ChatService chatService;
    @Autowired
    public UserController(UserService userService,ChatService chatService) {
        this.userService = userService;
        this.chatService = chatService;
    }
    @GetMapping("/login")
    public String H_login() {
        return "login";
    }

    @PostMapping("/login")
    public String set_user(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpSession session) {
       if (userService.login(username, password)) {
           session.setAttribute("username",username);
           return "redirect:/chat";
       } else {
           return "redirect:/login";
       }
    }

    @RequestMapping("/register")
    public String u_register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        if (userService.register(username,password)){
            return "redirect:/login";
        }else {
            return "redirect:/register";
        }
    }

    @GetMapping("/chat")
    public String a(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return"/chat";
        } else {
            return "redirect:/login";
        }
    }
    @PostMapping("/chat")
    @ResponseBody
    public List<ChatMessage> chat(@RequestParam String message, HttpSession session) {
        String username = (String) session.getAttribute("username");
        return chatService.addMessage(username,message);
    }

    @GetMapping("/chat1")
    @ResponseBody   // 返回请求体 也就是数据结果集
    public List<ChatMessage> cha(){
        return chatService.listAll();
    }

}


