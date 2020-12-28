package com.l.dao;

import com.l.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author l
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    /**
     * 通过用户名
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过用户名和密码找用户
     *
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
