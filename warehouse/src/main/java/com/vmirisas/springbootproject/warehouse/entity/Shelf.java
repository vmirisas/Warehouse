package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.ShelfDTO;
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
@Table(name = "shelf")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shelf_id")
    private Long shelfId;

    @ManyToOne( cascade = {CascadeType.DETACH,
//            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Column(name = "shelf_code")
    private String shelfCode;

    public Shelf(ShelfDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
