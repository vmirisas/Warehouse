package com.vmirisas.springbootproject.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vmirisas.springbootproject.warehouse.entity.Warehouse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarehouseDTO {

    private long warehouseId;
    private String warehouseCode;
    private String description;

    public WarehouseDTO(Warehouse warehouse) {
        BeanUtils.copyProperties(warehouse, this);
    }
}
