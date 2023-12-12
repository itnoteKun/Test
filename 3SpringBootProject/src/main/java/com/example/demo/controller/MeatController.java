package com.example.demo.controller;

import com.example.demo.entity.MeatEntity;
import com.example.demo.service.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@RestController
@RequestMapping("meatSupply")
public class MeatController {
    @Autowired
    private MeatService meatService;

    @RequestMapping("/list")
    public List<MeatEntity> list(){
        return meatService.list();
    }

}