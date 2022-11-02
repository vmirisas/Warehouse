package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
public class ShelfDTO {
    private Long shelfId;
    private String shelfCode;
    private Long warehouseId;
//    private List<Product> products;

    public ShelfDTO(Shelf shelf) {
        BeanUtils.copyProperties(shelf, this);
    }

}
