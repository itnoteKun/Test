package com.csk.service;

import com.csk.repository.UserRepository;
import com.csk.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author csk
 * @date 2023/11/26 22:13
 */
// 接口的实现类
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//利用有参构造导包
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public boolean register(String username, String password) {
        if (userRepository.findByUsername(username)==null){
            UserModel userModel = new UserModel(username, password);
            userRepository.saveAndFlush(userModel); // 保存数据到库
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean login(String username, String password) {
        return userRepository.findByUsername(username) != null && userRepository.findByUsername(username).getPassword().equals(password);
    }
}
