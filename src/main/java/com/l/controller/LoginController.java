package com.l.controller;

import com.l.dao.CategoryDao;
import com.l.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author l
 */
@RestController
public class LoginController {
    private final UserService userService;
    private final CategoryDao categoryDao;

    public LoginController(UserService userService, CategoryDao categoryDao) {
        this.userService = userService;
        this.categoryDao = categoryDao;
    }

//    @ApiOperation("登陆")
//    @PostMapping(value = "/login")
//    public Result<?> test(@RequestBody LoginUser requestUser) {
//        String username = requestUser.getUsername();
//        String password = requestUser.getPassword();
//        User user = userService.get(username, password);
//        if (user != null) {
//            return ResultFactory.buildResult(ResultCode.SUCCESS, "登陆成功", username);
//        } else {
//            return ResultFactory.buildFailResult("帐号或者密码错误");
//        }
//    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
