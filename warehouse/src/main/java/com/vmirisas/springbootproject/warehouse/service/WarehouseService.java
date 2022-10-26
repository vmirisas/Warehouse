package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.WarehouseDTO;

import java.util.List;

public interface WarehouseService {
    public List<WarehouseDTO> findAll();
    public WarehouseDTO findById (Long theId);
    public void save(WarehouseDTO theWarehouse);
    public void deleteById(Long theId);



}
