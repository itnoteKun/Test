package com.example.demo.controller;

import com.example.demo.entity.ShellEntity;
import com.example.demo.service.ShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shellRequests")
public class ShellController {
    @Autowired
    private ShellService shellService;

    @RequestMapping("/list")
    public List<ShellEntity> list(){
        return shellService.list();
    }

}