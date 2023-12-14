package com.mftplus.onlineshop.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/panel.do")
public class PanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") != null) {
            req.getRequestDispatcher("/jsp/panel.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login.do");
        }
    }
}
