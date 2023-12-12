package com.csk.service;

import org.springframework.stereotype.Service;

/**
 * @author csk
 * @date 2023/11/26 22:10
 */
@Service
public interface UserService {
    boolean register(String username, String password);
    boolean login(String username, String password);
}
