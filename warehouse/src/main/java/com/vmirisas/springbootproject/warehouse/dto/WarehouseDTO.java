package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import com.vmirisas.springbootproject.warehouse.entity.Warehouse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class WarehouseDTO {

    private Long warehouseId;
    private String warehouseCode;
    private String description;
    private List<ShelfDTO> shelves = new ArrayList<>();

    public WarehouseDTO(Warehouse warehouse) {
        BeanUtils.copyProperties(warehouse, this, "shelves");

        for (Shelf s : warehouse.getShelves()) {
            this.shelves.add(new ShelfDTO(s));
        }
    }

}
