package com.mftplus.onlineshop.model.service;

import com.mftplus.onlineshop.model.entity.ShoppingCart;
import com.mftplus.onlineshop.model.repository.CRUDRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingCartService implements Service<ShoppingCart,Long> {
    private static final ShoppingCartService shoppingCartService = new ShoppingCartService();

    private ShoppingCartService() {
    }

    public static ShoppingCartService getShoppingCartService() {
        return shoppingCartService;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) throws Exception {
        try (CRUDRepository<ShoppingCart,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(shoppingCart);
        }
    }

    @Override
    public ShoppingCart edit(ShoppingCart shoppingCart) throws Exception {
        try (CRUDRepository<ShoppingCart,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.edit(shoppingCart);
        }
    }

    @Override
    public ShoppingCart remove(Long id) throws Exception {
        try (CRUDRepository<ShoppingCart,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.remove(ShoppingCart.class,id);
        }
    }

    @Override
    public ShoppingCart findById(Long id) throws Exception {
        try (CRUDRepository<ShoppingCart,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findById(ShoppingCart.class,id);
        }
    }

    @Override
    public List<ShoppingCart> findAll() throws Exception {
        try (CRUDRepository<ShoppingCart,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findAll(ShoppingCart.class);
        }
    }

    public ShoppingCart findByUsername(String username) throws Exception {
        try (CRUDRepository<ShoppingCart,String> crudRepository = new CRUDRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("username",username);
            List<ShoppingCart> shoppingCarts = crudRepository.findBy("ShoppingCartFindUser",params);
            return (shoppingCarts.isEmpty() ? null : shoppingCarts.get(0));
        }
    }
}
