package com.example.demo.controller;


import com.example.demo.entity.FruitsPricesEntity;
import com.example.demo.service.FruitsPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("FruitsCleanPrice")
public class FruitsPricesController {
    @Autowired
    private FruitsPricesService fruitsPricesService;

    @RequestMapping("/list")
    public List<FruitsPricesEntity> list(){
        return fruitsPricesService.list();
    }

}