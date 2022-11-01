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
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "barcode")
    private String barcode;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "barcode")
    private List<Stock> stocks;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "barcode")
    private List<FormDetail> formDetailList;

    @Column(name = "description")
    private String description;

//    @Column(name = "quantity")
//    private int quantity;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,
//                    CascadeType.MERGE,
//                    CascadeType.PERSIST,
//                    CascadeType.REFRESH})
//    @JoinTable(
//            name = "stock",
//            joinColumns = @JoinColumn(name = "barcode"),
//            inverseJoinColumns = @JoinColumn (name = "shelf_code")
//    )
//    private List<Shelf> shelves;


    public Product(ProductDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
