package com.gyw.myconfig;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("user");
        if(user == null){
            request.setAttribute("msg","没有权限");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}