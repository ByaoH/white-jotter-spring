package com.l.service.impl;

import com.l.dao.UserDao;
import com.l.entity.User;
import com.l.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author l
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean isExist(String username) {
        return getByName(username) != null;
    }

    @Override
    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User get(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
