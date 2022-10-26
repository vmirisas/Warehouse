package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;


    private List<Shelf> shelves;


    public Product(ProductDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
    public void update(ProductDTO productDTO) {
        this.id = productDTO.getId();
        this.barcode = productDTO.getBarcode();
        this.description = productDTO.getDescription();
        this.quantity = productDTO.getQuantity();
        this.shelves = productDTO.getShelves();
    }
}
