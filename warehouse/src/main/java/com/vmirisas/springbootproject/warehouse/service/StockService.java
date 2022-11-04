package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.entity.Stock;

import java.util.List;

public interface StockService {

    List<StockDTO> findAll();
    StockDTO findById (Long theId);
    void save(StockDTO theStock);
    void save(Stock theStock);
    void deleteById(Long theId);
    int getStockToExport(String barcode, String shelfCode);
    StockDTO getStockExistence(String barcode, String shelfCode);
}
