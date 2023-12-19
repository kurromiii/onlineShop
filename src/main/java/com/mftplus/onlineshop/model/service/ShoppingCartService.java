package com.mftplus.onlineshop.model.service;

import com.mftplus.onlineshop.model.entity.ShoppingCart;
import com.mftplus.onlineshop.model.repository.CRUDRepository;

import java.util.List;


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
}
