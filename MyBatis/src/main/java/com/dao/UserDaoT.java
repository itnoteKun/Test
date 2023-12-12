package com.dao;

import com.pojo.Users;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author csk
 * @date 2023/11/30 20:16
 */
public class UserDaoT {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void test(){
        try{
            Users user = new Users();
//            user.setUsername("a");
            user.setId(1);
            List<Users> usersList = userDao.getUserList(user);
            for (Users users:usersList){
                System.out.println(users);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addUser(){
        Users users = new Users("李六","123123");
        Boolean bo = userDao.addUser(users);
        System.out.println(bo);
    }
    @Test
    public void delUser(){
        System.out.println(userDao.delUser("5"));
    }
    @Test
    public void updateUser(){
        Users user1 = new Users(6,"张六","123");
        Boolean bo = userDao.updateUser(user1);
        System.out.println(bo);

    }


}
