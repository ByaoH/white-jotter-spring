package com.l.utils;

import com.l.entity.User;
import com.l.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 获取当前请求的用户工具类
 *
 * @author l
 */
@Component
public class CurrentUserUtils {
    private final UserService userService;

    public CurrentUserUtils(UserService userService) {
        this.userService = userService;
    }

    public User getCurrentUser() {
        return userService.getByName(getCurrentUserName());
    }

    public void clear() {
        SecurityContextHolder.clearContext();
    }

    /**
     * TODO:由于在JWTAuthorizationFilter这个类注入UserDetailsServiceImpl一致失败，
     * 导致无法正确查找到用户，所以存入Authentication的Principal为从 token 中取出的当前用户的姓名
     */
    private static String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            return authentication.getPrincipal().toString();
        }
        return null;
    }
}
