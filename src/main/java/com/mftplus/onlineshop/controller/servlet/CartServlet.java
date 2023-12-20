package com.mftplus.onlineshop.controller.servlet;

import com.mftplus.onlineshop.model.entity.ShoppingCart;
import com.mftplus.onlineshop.model.entity.ShoppingCartItem;
import com.mftplus.onlineshop.model.entity.Stuff;
import com.mftplus.onlineshop.model.service.ShoppingCartItemService;
import com.mftplus.onlineshop.model.service.ShoppingCartService;
import com.mftplus.onlineshop.model.service.StuffService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/cart.do")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long stuffId = Long.parseLong(req.getParameter("stuffId"));
        System.out.println(stuffId);
        int count = Integer.parseInt(req.getParameter("count"));
        System.out.println(count);
        String username = req.getSession().getAttribute("username").toString();

        try {
            if (stuffId > 0 && count > 0 && username != null){
                Stuff stuff = StuffService.getStuffService().findById(stuffId);
                int price = stuff.getPrice();
                ShoppingCartItem shoppingCartItem =
                        ShoppingCartItem
                                .builder()
                                .stuff(stuff)
                                .price(price)
                                .count(count)
                                .build();
                ShoppingCartItemService.getShoppingCartItemService().save(shoppingCartItem);

//                User user = UserService.getUserService().findByUsername(username);
                ShoppingCart shoppingCart =
                        ShoppingCartService.getShoppingCartService().findByUsername(username);
                shoppingCart.addItem(shoppingCartItem);

                ShoppingCartService.getShoppingCartService().edit(shoppingCart);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
