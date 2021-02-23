package com.l.controller;

import com.l.entity.User;
import com.l.result.Result;
import com.l.result.ResultFactory;
import com.l.utils.CurrentUserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author l
 */
@Api(tags = "测试Controller")
@RestController
public class TestController {
    private final CurrentUserUtils currentUserUtils;

    public TestController(CurrentUserUtils currentUserUtils) {
        this.currentUserUtils = currentUserUtils;
    }

    @ApiOperation("获取当前用户")
    @GetMapping("/getCurrentUser")
    public Result<User> getCurrentUsername() {
        return ResultFactory.buildSuccessResult(currentUserUtils.getCurrentUser());
    }
}
