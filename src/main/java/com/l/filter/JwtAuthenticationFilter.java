//package com.l.filter;
//
//import com.alibaba.fastjson.JSON;
//import com.l.config.etc.SecurityConstants;
//import com.l.dto.LoginUser;
//import com.l.pojo.JwtUser;
//import com.l.result.Result;
//import com.l.result.ResultCode;
//import com.l.result.ResultFactory;
//import com.l.utils.JwtTokenUtils;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 如果用户名和密码正确，那么过滤器将创建一个JWT Token 并在HTTP Response 的header中返回它
// * 格式：token: "Bearer +具体token值"
// *
// * @author l
// */
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private ThreadLocal<Boolean> rememberMe = new ThreadLocal<>();
//    private AuthenticationManager authenticationManager;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//        super.setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
//    }
//
//    //    认证
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
////            获取登陆信息
//            LoginUser loginUser = JSON.parseObject(request.getInputStream(), LoginUser.class);
//            rememberMe.set(loginUser.getRememberMe());
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
//            return authenticationManager.authenticate(authenticationToken);
//        } catch (Exception e) {
//            Result<String> stringResult = ResultFactory.buildResult(ResultCode.UNAUTHORIZED, "认证信息有误", e.getMessage());
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.setContentType("application/json; charset=UTF-8");
//            try {
//                response.getWriter().write(JSON.toJSONString(stringResult));
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//            logger.error(e);
//            return null;
//        }
//    }
//
//    /**
//     * 如果验证成功，就生成token并返回
//     */
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
//        System.out.println(jwtUser);
//        List<String> roles = jwtUser.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), roles, rememberMe.get());
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType("application/json; charset=UTF-8");
//        Result<String> stringResult = ResultFactory.buildSuccessResult("认证成功!\n" +
//                        "你的角色:" + String.join(",", roles),
//                token);
//        response.getWriter().write(JSON.toJSONString(stringResult));
//    }
//
//    /**
//     * 认证失败调用该方法
//     */
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType("application/json; charset=UTF-8");
//        Result<String> stringResult = ResultFactory.buildResult(ResultCode.UNAUTHORIZED, "认证失败:", failed.getMessage());
//        response.getWriter().write(JSON.toJSONString(stringResult));
//    }
//}
