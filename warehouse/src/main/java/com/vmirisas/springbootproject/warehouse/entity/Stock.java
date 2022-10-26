package com.vmirisas.springbootproject.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "shelf_code")
    private String shelfCode;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private Date date;
}
