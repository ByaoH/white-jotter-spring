package com.l.result;

/**
 * 响应码枚举类
 *
 * @author l
 */
public enum ResultCode {
    //    成功
    SUCCESS(200),

    //    失败
    FAIL(400),

    //    未认证
    UNAUTHORIZED(401),

    //    资源不存在
    NOT_FOUND(404),
    
    //    服务器错误
    INTERNAL_SERVER_ERROR(500);

    public Integer code;

    ResultCode(Integer code) {
        this.code = code;
    }
}
