package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.WarehouseDTO;
import com.vmirisas.springbootproject.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseRestController {

    @Autowired
    private WarehouseService warehouseService;


    // expose "/warehouses" and return list of warehouses
    @GetMapping("/warehouse")
    public List<WarehouseDTO> findAll() {
        return warehouseService.findAll();
    }


    //  add mapping for GET /warehouses/{warehouseId}
    @GetMapping("/warehouse/{warehouseId}")
    public WarehouseDTO getWarehouse(@PathVariable Long warehouseId) {

        WarehouseDTO theWarehouse = warehouseService.findById(warehouseId);

        if(theWarehouse == null) {
            throw new RuntimeException("Warehouse id not found - " + warehouseId);
        }

        return theWarehouse;
    }

    // add mapping for POST /warehouses = add new warehouse
    @PostMapping("/warehouse")
    public WarehouseDTO addWarehouse(@RequestBody WarehouseDTO theWarehouse) {
        // also just in case the pass an ID in JSON ... set id to null


        theWarehouse.setId(0);

        warehouseService.save(theWarehouse);

        return theWarehouse;

    }

    // add mapping for PUT /warehouses = update existing warehouse
    @PutMapping("/warehouse")
    public WarehouseDTO updateWarehouse(@RequestBody WarehouseDTO theWarehouse) {

        warehouseService.save(theWarehouse);

        return theWarehouse;
    }

    // add mapping for DELETE /warehouses/{warehouseId} = delete existing warehouse
    @DeleteMapping("/warehouse/{warehouseId}")
    public String deleteWarehouse(@PathVariable Long warehouseId) {

        WarehouseDTO tempWarehouse = warehouseService.findById(warehouseId);

        if (tempWarehouse == null) {

            throw new RuntimeException("Warehouse id not found - " + warehouseId);
        }

        warehouseService.deleteById(warehouseId);

        return "Deleted warehouse id - " + warehouseId;
    }
}
