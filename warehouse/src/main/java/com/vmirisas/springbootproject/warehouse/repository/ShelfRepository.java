package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Long>, ShelfRepositoryCustom {
}
