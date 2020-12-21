package com.l.result;

/**
 * 用于创建 返回结果对象
 *
 * @author l
 */
public class ResultFactory {
    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static Result buildResult(ResultCode code, String message, Object data) {
        return buildResult(code.code, message, data);
    }
    
    public static Result buildResult(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }
}
