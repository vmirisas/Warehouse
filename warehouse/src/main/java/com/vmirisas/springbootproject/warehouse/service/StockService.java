package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.dto.search.StockSearch;
import com.vmirisas.springbootproject.warehouse.entity.Stock;

import java.util.List;

public interface StockService {

    List<Stock> findAll();
    Stock findById (Long theId);
    Stock save(StockDTO theStock);
    Stock save(Stock theStock);
    void deleteById(Long theId);
    List<StockDTO> search(StockSearch search);
    List<StockDTO> toDtoList(List<Stock> stockList);
    Stock toEntity(StockDTO stockDTO);

    StockDTO getStockToImport(String barcode, String shelfCode);

    int getStockToExport(String barcode, String shelfCode);
}
