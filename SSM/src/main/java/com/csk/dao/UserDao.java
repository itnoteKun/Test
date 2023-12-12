package com.csk.dao;

import com.csk.pojo.Users;

import java.util.List;


public interface UserDao{
    List<Users> getUserList(Users users);
    Users findByUsername(String user_name);
    Boolean addUser(Users users);
    Boolean delUser(String id);
    Boolean updataUser(Users users);
}
