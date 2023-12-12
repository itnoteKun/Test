package com.example.demo.controller;

import com.example.demo.entity.CityEntity;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cityNumberClean")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("/list")
    public List<CityEntity> list(){
        return cityService.list();
    }

}