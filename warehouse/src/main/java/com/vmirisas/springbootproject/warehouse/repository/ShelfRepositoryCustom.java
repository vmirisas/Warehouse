package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepositoryCustom {

    Shelf findShelfByCode(String shelfCode);
}
