package com.l.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应码
 *
 * @author l
 */
@Data
@AllArgsConstructor
public class Result {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息提示
     */
    public String message;
    /**
     * 返回结果
     */
    private Object data;
}
