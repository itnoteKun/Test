package com.csk;

import com.csk.dao.UserDao;
import com.csk.pojo.Users;
import com.csk.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserTest {

    @Autowired
    private ApplicationContext applicationContext;
    UserService userService = applicationContext.getBean(UserService.class);
    @Test
    public void test1(){
        Users user = new Users();

        user = userService.findByUsername("a");
        System.out.println(user);

    }
}
