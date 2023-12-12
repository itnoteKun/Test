package com.example.demo.service;

import com.example.demo.entity.Admin;

public interface AdminService {
    
    public Admin findByName(String name);

    public void createAdmin(Admin admin);

    public Admin findByNameAndPwd(Admin admin);
}
