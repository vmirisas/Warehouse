package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.WarehouseDTO;
import com.vmirisas.springbootproject.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseRestController {

    @Autowired
    private WarehouseService warehouseService;


    // expose "/warehouses" and return list of warehouses
    @GetMapping("")
    public List<WarehouseDTO> findAll() {
        return this.warehouseService.toDtoList(this.warehouseService.findAll());
    }

    //  add mapping for GET /warehouses/{warehouseId}
    @GetMapping("/{warehouseId}")
    public WarehouseDTO getWarehouse(@PathVariable Long warehouseId) {
        return new WarehouseDTO(this.warehouseService.findById(warehouseId));
    }

    // add mapping for POST /warehouses = add new warehouse
    @PostMapping("")
    public WarehouseDTO addWarehouse(@RequestBody WarehouseDTO theWarehouse){
        theWarehouse.setWarehouseId(null);
        return new WarehouseDTO(this.warehouseService.save(theWarehouse));
    }

    // add mapping for PUT /warehouses = update existing warehouse
    @PutMapping("")
    public WarehouseDTO updateWarehouse(@RequestBody WarehouseDTO theWarehouse) {
        return new WarehouseDTO(this.warehouseService.save(theWarehouse));
    }

    // add mapping for DELETE /warehouses/{warehouseId} = delete existing warehouse
    @DeleteMapping("/{warehouseId}")
    public String deleteWarehouse(@PathVariable Long warehouseId) {
        warehouseService.deleteById(warehouseId);
        return "Warehouse with id '" + warehouseId + "' deleted";
    }
}
