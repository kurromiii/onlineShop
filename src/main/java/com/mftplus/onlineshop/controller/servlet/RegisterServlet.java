package com.mftplus.onlineshop.controller.servlet;

import com.mftplus.onlineshop.model.entity.ShoppingCart;
import com.mftplus.onlineshop.model.entity.User;
import com.mftplus.onlineshop.model.service.ShoppingCartService;
import com.mftplus.onlineshop.model.service.UserService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j
@WebServlet (urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            if (name != null && family != null && username != null && password != null){
                User user =
                        User
                                .builder()
                                .name(name)
                                .family(family)
                                .username(username)
                                .password(password)
                                .build();
                UserService.getUserService().save(user);
                System.out.println("kir0");
                ShoppingCart shoppingCart =
                        ShoppingCart
                            .builder()
                            .customer(user)
                            .build();
                System.out.println(shoppingCart.toString());
                ShoppingCartService.getShoppingCartService().save(shoppingCart);
                System.out.println("kir2");
                System.out.println("user saved");
                log.info("saved");
                req.getSession().removeAttribute("register error");
                resp.sendRedirect("/panel.do");
            }
        } catch (Exception e) {
            System.out.println("kir3");
            System.out.println(e);
            req.getSession().setAttribute("register error", e.getMessage());
            resp.sendRedirect("/register.do");
        }
    }
}
