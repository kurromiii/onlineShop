package com.mftplus.onlineshop.model.service;

import com.mftplus.onlineshop.model.entity.Stuff;
import com.mftplus.onlineshop.model.repository.CRUDRepository;

import java.util.List;

public class StuffService implements Service<Stuff,Long> {
    private static final StuffService stuffService = new StuffService();

    private StuffService() {
    }

    public static StuffService getStuffService() {
        return stuffService;
    }
    @Override
    public Stuff save(Stuff stuff) throws Exception {
        try (CRUDRepository<Stuff,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(stuff);
        }
    }

    @Override
    public Stuff edit(Stuff stuff) throws Exception {
        try (CRUDRepository<Stuff,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.edit(stuff);
        }
    }

    @Override
    public Stuff remove(Long id) throws Exception {
        try (CRUDRepository<Stuff,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.remove(Stuff.class,id);
        }
    }

    @Override
    public Stuff findById(Long id) throws Exception {
        try (CRUDRepository<Stuff,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findById(Stuff.class,id);
        }
    }

    @Override
    public List<Stuff> findAll() throws Exception {
        try (CRUDRepository<Stuff,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findAll(Stuff.class);
        }
    }
}
