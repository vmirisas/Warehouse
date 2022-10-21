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

    @Column(name = "stock")
    private int stock;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(
            name = "product_shelf",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn (name = "shelf_id")
    )
    private List<Shelf> shelves;
}
