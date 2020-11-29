package com.lialong.im;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Slf4j
@Component
@Order(1)
public class ApiAspect {


    @Pointcut("execution(* com.lialong.im.controller.*Controller.*(..))")
    public void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        HttpServletResponse resp = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getResponse();
        try {
            Object result = pjp.proceed();
            if (result instanceof AjaxResult) {
                ResponseUtil.write(resp, JSONObject.toJSONString(result));
            } else {
                ResponseUtil.write(resp, JSONObject.toJSONString(AjaxResult.success(result)));
            }
        } catch (Exception ex) {
            ResponseUtil.write(resp, JSONObject.toJSONString(AjaxResult.fail("糟糕，网络开小差了，请刷新重试。")));
        }
        return null;
    }

}
