package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    public List<Warehouse> findAll();
    public Warehouse findById (Long theId);
    public void save(Warehouse theEmployee);
    public void deleteById(Long theId);

}
