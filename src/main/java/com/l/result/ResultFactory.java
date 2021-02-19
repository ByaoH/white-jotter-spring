package com.l.result;

/**
 * 用于创建 返回结果对象
 *
 * @author l
 */
public class ResultFactory {
    public static <T> Result<T> buildSuccessResult(T data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result<Void> buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static <T> Result<T> buildResult(ResultCode code, String message, T data) {
        return buildResult(code.code, message, data);
    }

    public static <T> Result<T> buildResult(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }
}
