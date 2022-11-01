package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.ShelfDTO;
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
@Table(name = "shelf")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shelf_id")
    private Long shelfId;

    @Column(name = "shelf_code")
    private String shelfCode;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "shelf_code")
    private List<Stock> stocks;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "shelf_code")
    private List<FormDetail> formDetailList;

    @ManyToOne (fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,
//            CascadeType.MERGE,
//            CascadeType.PERSIST,
//            CascadeType.REFRESH})
//    @JoinTable(
//            name = "stock",
//            joinColumns = @JoinColumn(name = "shelf_code"),
//            inverseJoinColumns = @JoinColumn (name = "barcode")
//    )
//    private List<Product> products;

    public Shelf(ShelfDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
