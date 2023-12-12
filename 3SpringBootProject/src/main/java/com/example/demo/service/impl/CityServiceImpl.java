package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.CityDao;
import com.example.demo.entity.CityEntity;
import com.example.demo.service.CityService;
import org.springframework.stereotype.Service;

@Service("CityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {
}