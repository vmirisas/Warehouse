package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.WarehouseDTO;
import com.vmirisas.springbootproject.warehouse.entity.Warehouse;
import com.vmirisas.springbootproject.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService{
@Autowired
    private WarehouseRepository warehouseRepository;


    @Override
    public List<WarehouseDTO> findAll() {

        List <Warehouse> warehouseList = warehouseRepository.findAll();
        List <WarehouseDTO> warehouseDTOList = new ArrayList<>();


        for (Warehouse warehouse:warehouseList) {
            warehouseDTOList.add(new WarehouseDTO(warehouse));
        }

        return warehouseDTOList;
    }

    @Override
    public WarehouseDTO findById(Long theId) {
        Optional<Warehouse> result = warehouseRepository.findById(theId);

        WarehouseDTO theWarehouse ;

        if (result.isPresent()) {

            theWarehouse = new WarehouseDTO(result.get()) ;
        } else {
            // we didn't find the warehouse
            throw new RuntimeException("Did not find warehouse id - " + theId);
        }

        return theWarehouse;
    }

    @Override
    public void save(WarehouseDTO theWarehouse) {
        warehouseRepository.save(new Warehouse(theWarehouse));
    }

    @Override
    public void deleteById(Long theId) {
        warehouseRepository.deleteById(theId);
    }
}
