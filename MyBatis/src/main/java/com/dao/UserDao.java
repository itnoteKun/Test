package com.dao;

import com.pojo.Users;

import java.util.List;

/**
 * @author csk
 * @date 2023/11/30 19:14
 */
public interface UserDao {
    List<Users> getUserList(Users users);
    Boolean addUser(Users users);
    Boolean delUser(String id);
    Boolean updateUser(Users users);
}
