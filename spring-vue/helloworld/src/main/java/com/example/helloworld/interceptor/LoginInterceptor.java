package com.example.helloworld.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vikingar
 * @time 2024/1/11 17:13
 * @description login interceptor
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor");
        // 暂时这么判断，有 cookie 能访问，没有 cookie 不让访问
//        return request.getCookies().length != 0;
        return true;
    }


}
