package com.l.config.etc;

/**
 * Security相关常量
 *
 * @author l
 */
public interface SecurityConstants {
    /**
     * swagger 过滤白名单
     */
    String[] SWAGGER_WHITELIST = {
            "/swagger-ui.html",
            "/swagger-ui/*",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars/**"
    };
    /**
     * druid过滤白名单
     */
    String[] DRUID_WHITELIST = {
            "/druid/**"
    };
    /**
     * jwt 请求头
     */
    String TOKEN_HEADER = "Authorization";
    /**
     * jwt 前缀
     */
    String TOKEN_PREFIX = "Bearer ";
    /**
     * 设置密匙
     */
    String SECRET = "white-jotter";
    /**
     * 设置发行人
     */
    String ISS = "byaoh";
    /**
     * 用于设置map key
     */
    String ROLE_CLAIMS = "rol";
    /**
     * 过期时间是3600秒，既是1个小时
     */
    long EXPIRATION = 60 * 60L;
    /**
     * 选择了记住我之后的过期时间为7天
     */
    long EXPIRATION_REMEMBER = 60 * 60 * 24 * 7L;
    
    String AUTH_LOGIN_URL = "/login";
}
