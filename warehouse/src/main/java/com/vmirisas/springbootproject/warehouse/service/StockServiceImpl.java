package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.entity.Stock;
import com.vmirisas.springbootproject.warehouse.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<StockDTO> findAll() {
        List <Stock> stockList = stockRepository.findAll();
        List <StockDTO> stockDTOList = new ArrayList<>();


        for (Stock stock:stockList) {
            stockDTOList.add(new StockDTO(stock));
        }

        return stockDTOList;
    }

    @Override
    public StockDTO findById(Long theId) {
        Optional<Stock> result = stockRepository.findById(theId);

        StockDTO theStock ;

        if (result.isPresent()) {

            theStock = new StockDTO(result.get()) ;
        } else {
            // we didn't find the stock
            throw new RuntimeException("Did not find stock id - " + theId);
        }

        return theStock;
    }

    @Override
    public void save(StockDTO theStock) {
        stockRepository.save(new Stock(theStock));
    }

    @Override
    public void save(Stock theStock){
        stockRepository.save(theStock);
    }

    @Override
    public void deleteById(Long theId) {
        stockRepository.deleteById(theId);
    }
}
