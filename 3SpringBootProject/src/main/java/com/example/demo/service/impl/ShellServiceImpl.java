package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.ShellDao;
import com.example.demo.entity.ShellEntity;
import com.example.demo.service.ShellService;
import org.springframework.stereotype.Service;

@Service("ShellService")
public class ShellServiceImpl extends ServiceImpl<ShellDao, ShellEntity> implements ShellService {
}