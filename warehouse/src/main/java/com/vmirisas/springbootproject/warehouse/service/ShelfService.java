package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.ShelfDTO;
import com.vmirisas.springbootproject.warehouse.entity.Shelf;

import java.util.List;

public interface ShelfService {
    List<Shelf> findAll();
    Shelf findById (Long theId);
    Shelf save(ShelfDTO theShelf);
    Shelf findShelfByCode(String theCode);
    void deleteById(Long theId);
    Shelf toEntity(ShelfDTO shelfDTO);
    List<ShelfDTO> toDtoList(List<Shelf> shelves);
}
