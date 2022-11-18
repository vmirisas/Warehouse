package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.dto.search.StockSearch;
import com.vmirisas.springbootproject.warehouse.entity.Stock;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockRepositoryCustom {

    List<StockDTO> search(StockSearch searchArgs);

    int getStockToExport(String barcode, String shelfCode);

    Stock getStockExistence(String barcode, String shelfCode);

    Stock getStockFromBarcodeAndDate(String barcode, Date date);


//    List<StockDTO> getImportsSumUntilDate(StockSearch searchArgs);
//
//    List<StockDTO> getExportsSumUntilDate(StockSearch searchArgs);
}
