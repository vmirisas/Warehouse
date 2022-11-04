package com.vmirisas.springbootproject.warehouse.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vmirisas.springbootproject.warehouse.dto.WarehouseDTO;
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
@Table(name = "warehouse")
public class Warehouse {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private long warehouseId;

    @Column(name = "warehouse_code")
    private String warehouseCode;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @OneToMany (    fetch = FetchType.LAZY,
                    mappedBy = "warehouse",
                    cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<Shelf> shelves;

    // define constructors
    // define getter/setter
    // define toString
    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + warehouseId +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Warehouse(WarehouseDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
