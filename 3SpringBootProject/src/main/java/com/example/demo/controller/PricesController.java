package com.example.demo.controller;

import com.example.demo.entity.PricesEntity;
import com.example.demo.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cropCleanPrice")
public class PricesController {
    @Autowired
    private PricesService pricesService;

    @RequestMapping("/list")
    public List<PricesEntity> list(){
        return pricesService.list();
    }

}