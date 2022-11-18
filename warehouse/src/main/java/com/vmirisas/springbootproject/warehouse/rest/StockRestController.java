package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.dto.search.StockSearch;
import com.vmirisas.springbootproject.warehouse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockRestController {

    @Autowired
    private StockService stockService;

    @GetMapping("")
    public List<StockDTO> findAll() {
        return this.stockService.toDtoList(this.stockService.findAll());
    }

    @GetMapping("/{stockId}")
    public StockDTO getStock(@PathVariable Long stockId) {
        return new StockDTO(this.stockService.findById(stockId));
    }

    @GetMapping("/search")
    public List<StockDTO> searchStocks(StockSearch search) {
        return this.stockService.search(search);
    }

    @GetMapping("/single")
    public StockDTO getProductStockUntilDate(@RequestParam String barcode,
                                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        return null;
    }

    @PostMapping("")
    public StockDTO addStock(@RequestBody StockDTO theStock) {
        // also just in case the pass an ID in JSON ... set id to null
        theStock.setStockId(null);
        return new StockDTO(this.stockService.save(theStock));
    }

    @PutMapping("")
    public StockDTO updateStock(@RequestBody StockDTO theStock) {
        return new StockDTO(this.stockService.save(theStock));
    }

    @DeleteMapping("/{stockId}")
    public String deleteStock(@PathVariable Long stockId) {
        stockService.deleteById(stockId);
        return "Deleted stock with id - " + stockId;
    }
}
