package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.Product;
import com.vmirisas.springbootproject.warehouse.entity.enums.ProductMeasurementUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
public class ProductDTO {

    private Long productId;
    private String barcode;
    private String description;
    private ProductMeasurementUnit unit;

    public ProductDTO(Product product) {
        BeanUtils.copyProperties(product, this);
    }
}


