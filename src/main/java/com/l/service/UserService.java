package com.l.service;

import com.l.entity.User;

/**
 * @author l
 */
public interface UserService {
    /**
     * @param username
     * @return
     */
    boolean isExist(String username);

    /**
     * @param username
     * @return
     */
    User getByName(String username);

    /**
     * @param username
     * @param password
     * @return
     */
    User get(String username, String password);

    /**
     * 新增用户
     *
     * @param user
     */
    void add(User user);

    /**
     * 检查密码是否一致
     *
     * @param rawPassword     加密密码
     * @param encodedPassword 未加密的密码
     * @return 一致返回true
     */
    boolean checkPassword(String rawPassword, String encodedPassword);
}
