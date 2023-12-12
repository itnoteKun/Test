package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.MeatDao;
import com.example.demo.entity.MeatEntity;
import com.example.demo.service.MeatService;
import org.springframework.stereotype.Service;

@Service("MeatService")
public class MeatServiceImpl extends ServiceImpl<MeatDao, MeatEntity> implements MeatService {
}