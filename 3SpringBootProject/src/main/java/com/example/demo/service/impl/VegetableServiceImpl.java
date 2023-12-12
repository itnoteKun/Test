package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.VegetablesDao;
import com.example.demo.entity.VegetablesEntity;
import com.example.demo.service.VegetableService;
import org.springframework.stereotype.Service;


@Service("VegetableService")
public class VegetableServiceImpl extends ServiceImpl<VegetablesDao, VegetablesEntity> implements VegetableService {

}

