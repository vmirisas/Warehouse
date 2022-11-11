package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShelfRepository extends JpaRepository<Shelf, Long>, ShelfRepositoryCustom {

    Optional<Shelf> findByShelfCode(String shelfCode);
}
