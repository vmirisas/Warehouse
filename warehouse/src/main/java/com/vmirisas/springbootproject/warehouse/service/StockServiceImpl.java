package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.dto.search.StockSearch;
import com.vmirisas.springbootproject.warehouse.entity.Product;
import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import com.vmirisas.springbootproject.warehouse.entity.Stock;
import com.vmirisas.springbootproject.warehouse.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private ShelfService shelfService;


    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findById(Long theId) {
        return this.stockRepository.findById(theId).orElseThrow(() -> new RuntimeException("Stock with id '" + theId + "' not found"));
    }

    @Override
    public Stock save(StockDTO theStock) {
        return stockRepository.save(toEntity(theStock));
    }

    @Override
    public Stock save(Stock theStock){
        return stockRepository.save(theStock);
    }

    @Override
    public void deleteById(Long theId) {
        Stock stock = this.stockRepository.findById(theId).orElseThrow(() -> new RuntimeException("Product with id '" + theId + "' not found"));
        stockRepository.delete(stock);
    }

    @Override
    public List<StockDTO> search(StockSearch search) {
        return stockRepository.search(search);
    }

    @Override
    public List<StockDTO> toDtoList(List<Stock> stockList) {
        List<StockDTO> list = new ArrayList<>();
        for (Stock s : stockList) {
            list.add(new StockDTO(s));
        }
        return list;
    }
    public StockDTO getStockToImport(String barcode, String shelfCode) {
        Optional<Stock> result = Optional.ofNullable(stockRepository.getStockExistence(barcode, shelfCode));

        StockDTO theStock;

        if (result.isPresent()) {
            theStock = new StockDTO(result.get());
        }
        else {
            theStock = new StockDTO();
//            throw new RuntimeException("The stock with barcode: " + barcode + " and shelf code: " + shelfCode + " doesn't exist.");
        }

        return theStock;
    }

    public int getStockToExport(String barcode, String shelfCode) {
        Optional<Integer> result = Optional.ofNullable(stockRepository.getStockToExport(barcode, shelfCode));

        Integer quantity;

        if (result.isPresent()) {
            quantity = result.get();
        } else {
            throw new RuntimeException("Did not find the stock with barcode: " + barcode + " and shelf code: " + shelfCode + " for export.");
        }

        return quantity;
    }

    public StockDTO getStockFromBarcodeAndDate(String barcode, Date date) {
        Optional<Stock> result = Optional.ofNullable(stockRepository.getStockFromBarcodeAndDate(barcode, date));

        StockDTO stockDTO;

        if (result.isPresent()) {
            stockDTO = new StockDTO(result.get());
        } else {
            throw new RuntimeException("Did not find stock of the product with barcode: " + barcode + " until the date " + date);
        }

        return stockDTO;
    }
    @Override
    public Stock toEntity(StockDTO stockDTO) {
        Stock stock = new Stock(stockDTO);

        Shelf shelf = this.shelfService.findShelfByCode(stockDTO.getShelfCode());
        stock.setShelf(shelf);

        Product product = this.productService.findProductByBarcode(stockDTO.getBarcode());
        stock.setProduct(product);

        stock.setQuantity(stock.getQuantity());
        stock.setDate(stockDTO.getDate());

        return stock;
    }


}
