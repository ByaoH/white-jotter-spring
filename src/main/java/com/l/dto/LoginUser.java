package com.l.dto;

import lombok.Data;

/**
 * 用户请求登陆dto
 *
 * @author l
 */
@Data
public class LoginUser {
    private String username;
    private String password;
    private Boolean rememberMe;
}
