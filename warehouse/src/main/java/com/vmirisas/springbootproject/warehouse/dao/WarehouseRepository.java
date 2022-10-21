package com.vmirisas.springbootproject.warehouse.dao;

import com.vmirisas.springbootproject.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
