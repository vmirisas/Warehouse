package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.ShelfDTO;

import java.util.List;

public interface ShelfService {
    public List<ShelfDTO> findAll();
    public ShelfDTO findById (Long theId);
    public void save(ShelfDTO theShelf);
    ShelfDTO findShelfByCode(String theCode);
    public void deleteById(Long theId);
}
