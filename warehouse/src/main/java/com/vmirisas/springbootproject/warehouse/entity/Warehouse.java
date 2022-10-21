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
}
