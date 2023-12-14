package com.mftplus.onlineshop.controller.servlet;

import com.mftplus.onlineshop.model.entity.User;
import com.mftplus.onlineshop.model.service.UserService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
@Log4j
@WebServlet (urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        if (remember != null && remember.equals("on")){
            Cookie uCookie = new Cookie("username",username);
            Cookie pCookie = new Cookie("password",password);
            resp.addCookie(uCookie);
            resp.addCookie(pCookie);
        }

        try {
            if (UserService.getUserService().findByUsernameAndPassword(username,password) != null){
                req.getSession().setAttribute("username",username);
                req.getSession().removeAttribute("error");
                resp.sendRedirect("/panel.do");
                System.out.println("user logged in");
                log.info("user logged in");
            }
        } catch (Exception e) {
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("/login.do");
        }


    }
}
