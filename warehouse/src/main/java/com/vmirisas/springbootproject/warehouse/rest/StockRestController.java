package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StockRestController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stock")
    public List<StockDTO> findAll() {
        return stockService.findAll();
    }

    @GetMapping("/stock/{stockId}")
    public StockDTO getStock(@PathVariable Long stockId) {

        StockDTO theStock = stockService.findById(stockId);

        if(theStock == null) {
            throw new RuntimeException("Stock id not found - " + stockId);
        }

        return theStock;
    }

    @PostMapping("/stock")
    public StockDTO addStock(@RequestBody StockDTO theStock) {
        // also just in case the pass an ID in JSON ... set id to null

        theStock.setStockId(0L);

        stockService.save(theStock);

        return theStock;
    }

    @PutMapping("/stock")
    public StockDTO updateStock(@RequestBody StockDTO theStock) {

        stockService.save(theStock);

        return theStock;
    }

    @DeleteMapping("/stock/{stockId}")
    public String deleteStock(@PathVariable Long stockId) {

        StockDTO tempStock = stockService.findById(stockId);

        if (tempStock == null) {

            throw new RuntimeException("Stock id not found - " + stockId);
        }

        stockService.deleteById(stockId);

        return "Deleted stock id - " + stockId;
    }


}
