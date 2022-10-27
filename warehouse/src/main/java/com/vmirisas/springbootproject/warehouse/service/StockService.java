package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;

import java.util.List;

public interface StockService {

    List<StockDTO> findAll();
    StockDTO findById (Long theId);
    void save(StockDTO theStock);
    void deleteById(Long theId);
}
