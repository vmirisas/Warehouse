package com.vmirisas.springbootproject.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shelf")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "shelf_code")
    private String shelfCode;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(
            name = "product_shelf",
            joinColumns = @JoinColumn(name = "shelf_id"),
            inverseJoinColumns = @JoinColumn (name = "product_id")
    )
    private List<Product> products;

}
