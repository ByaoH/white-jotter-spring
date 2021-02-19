package com.l.controller;

import com.l.entity.User;
import com.l.result.Result;
import com.l.result.ResultCode;
import com.l.result.ResultFactory;
import com.l.service.UserService;
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
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    public Result test(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        User user = userService.get(username, password);
        if (user != null) {
            return ResultFactory.buildResult(ResultCode.SUCCESS, "登陆成功", username);
        } else {
            return ResultFactory.buildFailResult("帐号或者密码错误");
        }
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
