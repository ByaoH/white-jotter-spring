package com.l.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置跨域，经测试 使用vue项目的反向代理可以不需要设置跨域
 *
 * @author l
 */
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                //暴露header中的其他属性给客户端应用程序
                //如果不设置这个属性前端无法通过response header获取到Authorization也就是token
                .exposedHeaders("Authorization")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600L);
    }
}
