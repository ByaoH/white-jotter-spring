package com.l.service;

import com.l.dto.LoginUser;
import com.l.entity.User;
import com.l.pojo.JwtUser;
import com.l.utils.CurrentUserUtils;
import com.l.utils.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 认证service
 *
 * @author l
 */
@Service
public class AuthService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final StringRedisTemplate stringRedisTemplate;

    private final UserService userService;

    private final CurrentUserUtils currentUserUtils;


    public AuthService(StringRedisTemplate stringRedisTemplate, UserService userService, CurrentUserUtils currentUserUtils) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.userService = userService;
        this.currentUserUtils = currentUserUtils;
    }

    /**
     * 返回该用户的token
     *
     * @param loginUser 不能为空
     * @return 包含该用户名和权限信息的token
     * @throws BadCredentialsException 密码错误或者帐号已禁用会抛出
     */
    public String getToken(LoginUser loginUser) throws BadCredentialsException {
        User user = userService.getByName(loginUser.getUsername());
//        判断是否一致
        if (user == null || !userService.checkPassword(loginUser.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("用户名或密码不正确");
        }
        JwtUser jwtUser = new JwtUser(user);
//        判断是否启用
        if (!jwtUser.isEnabled()) {
            throw new BadCredentialsException("帐号已停用");
        }
        List<String> roleList = jwtUser.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String token = JwtTokenUtils.createToken(user.getUsername(), roleList, loginUser.getRememberMe());
//        由于用户名也是唯一，所以作为key存入redis
        stringRedisTemplate.opsForValue().set("token:" + user.getUsername(), token);
        return token;
    }

    /**
     * 删除当前用户的token
     *
     * @return 当前用户名
     */
    public String deleteTokenFromRedis() {
        String username = currentUserUtils.getCurrentUser().getUsername();
        stringRedisTemplate.delete("tooken:" + username);
        currentUserUtils.clear();
        return username;
    }
}
