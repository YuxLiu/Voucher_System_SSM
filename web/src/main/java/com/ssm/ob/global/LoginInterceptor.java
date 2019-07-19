package com.ssm.ob.global;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 还要在 spring-web 里配置拦截器
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 放行 登录 URI
        String url = request.getRequestURI();
        if (url.toLowerCase().contains("login")) {
            return true;
        }
        // 放行 已登录者
        if (request.getSession().getAttribute("employee") != null) {
            return true;
        }

        // 拦截
        response.sendRedirect("/to_login");
        return false;
    }
}
