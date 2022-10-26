package com.vmirisas.springbootproject.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "form_detail")
public class FormDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "transaction_code_id")
    private Long transactionFormId;

    @Column(name = "shelfCode")
    private String shelfCode;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "quantity")
    private int quantity;
}
