package com.example.demo.controller;


import com.example.demo.entity.CroppriceEntity;
import com.example.demo.service.CroppriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dynamic")
public class CroppriceController {
    @Autowired
    private CroppriceService CroppriceService;

    @RequestMapping("/list")
    public List<CroppriceEntity> list(){
        return CroppriceService.list();
    }

}