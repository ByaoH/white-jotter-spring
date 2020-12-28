package com.l.service;

import com.l.pojo.User;

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
     * @param user
     */
    void add(User user);
}
