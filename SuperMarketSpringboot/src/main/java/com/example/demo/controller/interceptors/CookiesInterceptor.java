package com.example.demo.controller.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class CookiesInterceptor extends HandlerInterceptorAdapter {

    @PostConstruct
    private void init()
    {
        System.out.println("init in CookiesInterceptor");
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle in CookiesInterceptor");
        return true ;

    }
}
