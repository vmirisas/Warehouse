package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.entity.Stock;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepositoryCustom {

    int getStockToExport(String barcode, String shelfCode);

    Stock getStockExistence(String barcode, String shelfCode);

}
