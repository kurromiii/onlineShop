package com.mftplus.onlineshop.model.service;

import com.mftplus.onlineshop.model.entity.ShoppingCartItem;
import com.mftplus.onlineshop.model.repository.CRUDRepository;

import java.util.List;

public class ShoppingCartItemService implements Service<ShoppingCartItem,Long> {
    private static final ShoppingCartItemService shoppingCartItemService = new ShoppingCartItemService();

    private ShoppingCartItemService() {
    }

    public static ShoppingCartItemService getShoppingCartItemService() {
        return shoppingCartItemService;
    }
    @Override
    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem) throws Exception {
        try (CRUDRepository<ShoppingCartItem,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(shoppingCartItem);
        }
    }

    @Override
    public ShoppingCartItem edit(ShoppingCartItem shoppingCartItem) throws Exception {
        try (CRUDRepository<ShoppingCartItem,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.edit(shoppingCartItem);
        }
    }

    @Override
    public ShoppingCartItem remove(Long id) throws Exception {
        try (CRUDRepository<ShoppingCartItem,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.remove(ShoppingCartItem.class,id);
        }
    }

    @Override
    public ShoppingCartItem findById(Long id) throws Exception {
        try (CRUDRepository<ShoppingCartItem,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findById(ShoppingCartItem.class,id);
        }
    }

    @Override
    public List<ShoppingCartItem> findAll() throws Exception {
        try (CRUDRepository<ShoppingCartItem,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findAll(ShoppingCartItem.class);
        }
    }
}
