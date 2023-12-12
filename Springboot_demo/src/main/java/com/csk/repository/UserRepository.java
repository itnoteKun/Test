package com.csk.repository;

import com.csk.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author csk
 * @date 2023/11/26 22:06
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByUsername(String username);
}
