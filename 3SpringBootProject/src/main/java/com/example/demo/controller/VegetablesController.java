package com.example.demo.controller;

import com.example.demo.entity.VegetablesEntity;

import com.example.demo.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("vegetablesRequests")
public class VegetablesController {
    @Autowired
    private VegetableService vegetableService;

    @RequestMapping("/list")
    public List<VegetablesEntity> list(){ return vegetableService.list();
    }

}