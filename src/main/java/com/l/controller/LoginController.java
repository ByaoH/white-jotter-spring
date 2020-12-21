package com.l.controller;

import com.l.pojo.User;
import com.l.result.Result;
import com.l.result.ResultFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author l
 */
@RestController
public class LoginController {
    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    public Result test(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        if ("admin".equals(username) && "123456".equals(password)) {
            return ResultFactory.buildSuccessResult(requestUser);
        } else {
            return ResultFactory.buildFailResult("帐号或者密码错误");
        }
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
