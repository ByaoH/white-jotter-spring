package com.l.config.aop;

import com.l.result.Result;
import com.l.result.ResultFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

/**
 * @author l
 */
@Component
@Aspect
public class ControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    @Pointcut("execution(public com.l.result.Result com.l.controller.*.*(..))")

    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        Result<?> result = null;
        try {
            result = (Result<?>) pjp.proceed();
            long stopTime = System.currentTimeMillis();
            logger.info(pjp.getSignature() + getArgs(pjp) + " use time:" + (stopTime - startTime) + "ms");
        } catch (Throwable throwable) {
            result = handlerException(pjp, throwable);
        } finally {
            return result;
        }
    }

    private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        if (e instanceof DataIntegrityViolationException) {
            String message = "正在破坏约束关系";
            logger.warn(pjp.getSignature() + getArgs(pjp) + message);
            return ResultFactory.buildFailResult(message);
        }
        if (e instanceof BadCredentialsException) {
            logger.warn("认证失败:" + getArgs(pjp) + e);
            return ResultFactory.buildFailResult("认证失败:" + e.getMessage());
        }
        logger.error(pjp.getSignature() + getArgs(pjp) + "未设置异常处理:" + e);
        return ResultFactory.buildFailResult("错误" + e);
    }

    private String getArgs(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        StringBuffer sb;
        if (args != null) {
            sb = new StringBuffer();
            for (Object arg : args) {
                sb.append(arg + " ,");
            }
            return "args:(" + sb.toString() + ")";
        }
        return "";
    }
}
