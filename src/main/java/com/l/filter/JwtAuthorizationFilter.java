package com.l.filter;

import com.l.config.etc.SecurityConstants;
import com.l.utils.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 过滤器处理所有HTTP请求，并检查是否存在带有正确令牌的Authorization标头。
 * 例如，如果令牌未过期或签名密钥正确。
 *
 * @author l
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorization = request.getHeader(SecurityConstants.TOKEN_HEADER);
//        如果没有 就放行
        if (authorization == null || !authorization.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置授权信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(authorization));
        super.doFilterInternal(request, response, chain);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String authorization) {
        String token = authorization.replace(SecurityConstants.TOKEN_PREFIX, "");
        String username = JwtTokenUtils.getUsernameByToken(token);
        List<SimpleGrantedAuthority> roles = JwtTokenUtils.getUserRolesByToken(token);
//        如果String不为null ，并且其长度大于0，并且包含至少一个非空白字符，则返回true 。
        if (StringUtils.hasText(username)) {
            return new UsernamePasswordAuthenticationToken(username, null, roles);
        }
        return null;
    }
}
