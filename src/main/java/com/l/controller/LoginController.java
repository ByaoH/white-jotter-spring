package com.l.controller;

import com.l.dto.LoginUser;
import com.l.result.Result;
import com.l.result.ResultFactory;
import com.l.service.AuthService;
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

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    public Result<?> test(@RequestBody LoginUser requestUser) {
        String token = authService.getToken(requestUser);
        Result<String> stringResult = ResultFactory.buildSuccessResult("认证成功!", token);
        return stringResult;

    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
