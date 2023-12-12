package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.FruitsPricesDao;
import com.example.demo.entity.FruitsPricesEntity;
import com.example.demo.service.FruitsPricesService;
import org.springframework.stereotype.Service;

@Service("FruitsPricesService")
public class FruitsPricesServiceImpl extends ServiceImpl<FruitsPricesDao, FruitsPricesEntity> implements FruitsPricesService {
}