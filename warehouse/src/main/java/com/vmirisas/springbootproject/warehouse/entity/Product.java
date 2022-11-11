package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.ProductDTO;
import com.vmirisas.springbootproject.warehouse.entity.enums.ProductMeasurementUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "measurement_unit")
    private ProductMeasurementUnit unit;

    public Product(ProductDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
