package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

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
    @Column(name = "stock_id")
    private Long stockId;

    @ManyToOne(fetch = FetchType.EAGER,
        cascade = {CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH})
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private Date date;

    public Stock(StockDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
