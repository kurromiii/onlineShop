package com.mftplus.onlineshop.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/cart.do")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stuffId = Integer.parseInt(req.getParameter("stuffId"));
        int price = Integer.parseInt(req.getParameter("price"));
        int count = Integer.parseInt(req.getParameter("count"));
    }
}
