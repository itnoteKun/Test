package com.csk.service;

import com.csk.dao.UserDao;
import com.csk.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService  {

    @Autowired
    private ApplicationContext applicationContext;
    UserDao userDao = applicationContext.getBean(UserDao.class);

//    @Override
    public List<Users> getUserList(Users users) {
        List<Users> userList = userDao.getUserList(users);
        return userList;
    }
//    @Override
    public Users findByUsername(String user_name){
        Users users = userDao.findByUsername(user_name);
        return users;
    }
//    @Override
    public Boolean addUser(Users users){

        return new Boolean(userDao.addUser(users));
    }
//    @Override
    public Boolean delUser(String id){
        return new Boolean(userDao.delUser(id));
    }

//    @Override
    public Boolean updataUser(Users users){
        return new Boolean(userDao.updataUser(users));
    }


}
