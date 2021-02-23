package com.l.service.impl;

import com.l.entity.User;
import com.l.pojo.JwtUser;
import com.l.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author l
 * springSecurity需要实现UserDetailsService接口供权限框架调用
 * 只需要实现一个方法，就是根据用户名去获取用户
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByName(username);
        return new JwtUser(user);
    }
}
