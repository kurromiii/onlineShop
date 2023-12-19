package com.mftplus.onlineshop.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (urlPatterns = "/jsp/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        if (request.getRequestURI().equals("/home.do")) {
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//        else if (request.getRequestURI().equals("/login.do")) {
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//        else if (request.getRequestURI().equals("/register.do")) {
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//        else if (request.getSession().getAttribute("username") == null){
//            response.sendRedirect("/html/home.jsp");
//        }
//        else if (request.getRequestURI().toLowerCase().endsWith(".jsp")){
//            request.getSession().setAttribute("error","No access to admin pages!");
//            response.sendRedirect("/home.do");
//        }
//        else if (request.getRequestURI().equals("/html/errorPage.html")){
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//        else {
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
    }
}
