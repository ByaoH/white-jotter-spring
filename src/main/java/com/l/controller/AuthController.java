package com.l.controller;

import com.l.dto.LoginUser;
import com.l.result.Result;
import com.l.result.ResultFactory;
import com.l.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author l
 */
@RestController
@Api(tags = "认证")
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    public Result<?> login(@RequestBody LoginUser requestUser) {
        String token = authService.getToken(requestUser);
        return ResultFactory.buildSuccessResult("认证成功!", token);

    }

    @ApiOperation("登出")
    @GetMapping("/logout")
    public Result<Void> logout() {
        String username = authService.deleteTokenFromRedis();
        return ResultFactory.buildSuccessResult(username + " 你已登出...");
    }
}
