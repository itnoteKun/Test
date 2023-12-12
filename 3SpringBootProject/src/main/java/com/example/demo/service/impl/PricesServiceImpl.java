package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.PricesDao;
import com.example.demo.entity.PricesEntity;
import com.example.demo.service.PricesService;
import org.springframework.stereotype.Service;

@Service("PricesService")
public class PricesServiceImpl extends ServiceImpl<PricesDao, PricesEntity> implements PricesService {
}