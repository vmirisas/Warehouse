package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.Product;
import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String barcode;
    private String description;
    private int quantity;
    private List<Shelf> shelves;

    public ProductDTO(Product product) {
        BeanUtils.copyProperties(product, this);
    }
}


