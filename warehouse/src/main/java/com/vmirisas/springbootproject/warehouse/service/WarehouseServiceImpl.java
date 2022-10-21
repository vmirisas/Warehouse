package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dao.WarehouseRepository;
import com.vmirisas.springbootproject.warehouse.entity.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService{

    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository theWarehouseRepository) {
        warehouseRepository = theWarehouseRepository;
    }
    @Override
    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse findById(Long theId) {
        Optional<Warehouse> result = warehouseRepository.findById(theId);

        Warehouse theWarehouse = null;

        if (result.isPresent()) {
            theWarehouse = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theWarehouse;
    }

    @Override
    public void save(Warehouse theWarehouse) {
        warehouseRepository.save(theWarehouse);
    }

    @Override
    public void deleteById(Long theId) {
        warehouseRepository.deleteById(theId);
    }
}
