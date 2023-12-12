package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.CroppriceDao;
import com.example.demo.entity.CroppriceEntity;
import com.example.demo.service.CroppriceService;
import org.springframework.stereotype.Service;

@Service("CroppriceService")
public class CroppriceServiceImpl extends ServiceImpl<CroppriceDao, CroppriceEntity> implements CroppriceService {

}