package com.mftplus.onlineshop.model.service;

import com.mftplus.onlineshop.controller.exception.AccessDeniedException;
import com.mftplus.onlineshop.controller.exception.DuplicateUsernameException;
import com.mftplus.onlineshop.model.entity.User;
import com.mftplus.onlineshop.model.repository.CRUDRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements Service<User,String>{
    private static UserService userService = new UserService();

    private UserService() {
    }

    public static UserService getUserService() {
        return userService;
    }

    @Override
    public User save(User user) throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            if (findByUsername(user.getUsername())==null){
                return crudRepository.save(user);
            }else {
                throw new DuplicateUsernameException("Username is already taken");
            }
        }
    }

    @Override
    public User edit(User user) throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.edit(user);
        }
    }

    @Override
    public User remove(String id) throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.remove(User.class,id);
        }
    }

    @Override
    public User findById(String id) throws Exception {
        return null;
    }

    public User findByUsername(String username) throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("username",username);
            List<User> userList = crudRepository.findBy("User.FindByUsername",params);
            return (userList.isEmpty() ? null : userList.get(0));
        }
    }

    public User findByUsernameAndPassword(String username,String password) throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("username",username);
            params.put("password",password);
            List<User> userList = crudRepository.findBy("User.FindByUsernameAndPassword",params);
            if (userList.isEmpty()){
                throw new AccessDeniedException("Wrong username/password");
            }else {
                return userList.get(0);
            }
        }
    }

    @Override
    public List<User> findAll() throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.findAll(User.class);
        }
    }
}
