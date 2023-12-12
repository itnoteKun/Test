package com.dao;

import com.pojo.Users;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author csk
 * @date 2023/12/4 9:16
 */
public class UserDaoImpl implements UserDao{

    @Override
    public List<Users> getUserList(Users users){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Users> userList = mapper.getUserList(users);
        sqlSession.close();
        return userList;
    }

    @Override
    public Boolean addUser(Users users){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Boolean bo = mapper.addUser(users);
        sqlSession.commit(); //自动提交事务
        sqlSession.close();
        return bo;
    }

    @Override
    public Boolean delUser(String id){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Boolean bo = mapper.delUser(id);
        sqlSession.commit();
        sqlSession.close();
        return bo;
    }

    @Override
    public Boolean updateUser(Users users){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.dao.UserDao.updateUser";
        int count = sqlSession.update(sqlId,users);
        sqlSession.commit();
        sqlSession.close();
        if (count>0){
        return  true;
        }else return false;
    }

}
