package com.example.demo.service.impl;

import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin findByName(String name) {
        return adminMapper.findByName(name);
    }

    @Override
    public void createAdmin(Admin admin) {
        adminMapper.createAdmin(admin);
    }

    @Override
    public Admin findByNameAndPwd(Admin admin) {
        return adminMapper.findByNameAndPwd(admin);
    }
}

