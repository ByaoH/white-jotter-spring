package com.l.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author l
 */
@RestController
public class LoginController {
    @ApiOperation("测试前后端交互的接口")
    @PostMapping(value = "/test")
    public JSONObject test(@RequestBody JSONObject requestJSON) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("data", requestJSON);
        return jsonObject;
    }
}
