package com.vmirisas.springbootproject.warehouse.entity;

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
    @Column(name = "id")
    private long id;

    @Column(name = "warehouse_code")
    private String warehouseCode;

    @Column(name = "description")
    private String description;

    @OneToMany (fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "warehouse_id")
    private List<Shelf> shelves;

    // define constructors
    // define getter/setter
    // define toString
    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Warehouse(WarehouseDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
