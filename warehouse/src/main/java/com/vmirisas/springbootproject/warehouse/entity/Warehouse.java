package com.vmirisas.springbootproject.warehouse.entity;

import javax.persistence.*;

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

    public Warehouse() {

    }

    public Warehouse( String warehouseCode, String description) {
        this.warehouseCode = warehouseCode;
        this.description = description;
    }


    // define getter/setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


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
