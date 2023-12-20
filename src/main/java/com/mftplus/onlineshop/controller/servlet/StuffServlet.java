package com.mftplus.onlineshop.controller.servlet;

import com.mftplus.onlineshop.model.entity.Stuff;
import com.mftplus.onlineshop.model.service.StuffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/stuff.do")
public class StuffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/stuff.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String brand = req.getParameter("brand");
        String category = req.getParameter("category");
        int price = Integer.parseInt(req.getParameter("price"));

        try {
            if (name != null && group != null){
                Stuff stuff =
                        Stuff
                        .builder()
                        .name(name)
                        .group(group)
                        .brand(brand)
                        .price(price)
                        .build();
                StuffService.getStuffService().save(stuff);
                System.out.println("stuff saved");
                req.getSession().setAttribute("name",name);
                resp.sendRedirect("/home.do");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
