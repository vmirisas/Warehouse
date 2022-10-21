package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.entity.Warehouse;
import com.vmirisas.springbootproject.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseRestController {

    private WarehouseService warehouseService;

    @Autowired
    public WarehouseRestController (WarehouseService theWarehouseService) {
        warehouseService = theWarehouseService;
    }

    // expose "/warehouses" and return list of warehouses
    @GetMapping("/warehouse")
    public List<Warehouse> findAll() {
        return warehouseService.findAll();
    }

    //  add mapping for GET /employees/{employeeId}
    @GetMapping("/warehouse/{warehouseId}")
    public Warehouse getWarehouse(@PathVariable Long warehouseId) {

        Warehouse theWarehouse = warehouseService.findById(warehouseId);

        if(theWarehouse == null) {
            throw new RuntimeException("Warehouse id not found - " + warehouseId);
        }

        return theWarehouse;
    }

    // add mapping for POST /employees = add new employee
    @PostMapping("/warehouse")
    public Warehouse addEmployee(@RequestBody Warehouse theWarehouse) {
        // also just in case the pass an ID in JSON ... set id to 0

        theWarehouse.setId(0);

        warehouseService.save(theWarehouse);

        return theWarehouse;

    }

    // add mapping for PUT /employees = update existing employee
    @PutMapping("/warehouse")
    public Warehouse updateWarehouse(@RequestBody Warehouse theWarehouse) {

        warehouseService.save(theWarehouse);

        return theWarehouse;
    }

    // add mapping for DELETE /employees/{employeeId} = delete existing employee
    @DeleteMapping("/warehouse/{warehouseId}")
    public String deleteWarehouse(@PathVariable Long warehouseId) {

        Warehouse tempWarehouse = warehouseService.findById(warehouseId);

        if (tempWarehouse == null) {

            throw new RuntimeException("Warehouse id not found - " + warehouseId);
        }

        warehouseService.deleteById(warehouseId);

        return "Deleted warehouse id - " + warehouseId;
    }
}
