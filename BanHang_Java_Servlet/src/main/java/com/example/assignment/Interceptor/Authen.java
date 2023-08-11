package com.example.assignment.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class Authen implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response, Object handle
    ) throws IOException {
        HttpSession session = request.getSession();


        if(session.getAttribute("admin") != null ){
            return true;
        }
        if(session.getAttribute("user") == null && session.getAttribute("admin") == null ){
            session.setAttribute("error","vui lòng đăng nhập ");
            response.sendRedirect("/dangnhap");
            return false;
        }

        if(session.getAttribute("user") == null){
            session.setAttribute("error","vui lòng đăng nhập ");
            session.removeAttribute("admin");
            response.sendRedirect("/dangnhap");
            return false;
        }

        return true;
    }
}
