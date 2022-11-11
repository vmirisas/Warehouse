package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.ShelfDTO;
import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import com.vmirisas.springbootproject.warehouse.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService{

    @Autowired
    private ShelfRepository shelfRepository;

//    @Autowired private WarehouseService warehouseService;

    @Override
    public List<Shelf> findAll() {
        return shelfRepository.findAll();
//        List <Shelf> shelvesList = shelfRepository.findAll();
//        List <ShelfDTO> shelvesDTOList = new ArrayList<>();
//
//        for (Shelf shelf:shelvesList) {
//
//            ShelfDTO shelfDTO = new ShelfDTO(shelf);
//
//            shelvesDTOList.add(shelfDTO);
//        }
//
//        return shelvesDTOList;
    }

    @Override
    public Shelf findById(Long theId) {
        return this.shelfRepository.findById(theId).orElseThrow(() -> new RuntimeException("Shelf with id '" + theId + "' not found"));
//        Optional<Shelf> result = shelfRepository.findById(theId);
//
//        ShelfDTO shelfDTO;
//
//        if (result.isPresent()) {
//
//            shelfDTO = new ShelfDTO(result.get()) ;
//
//        } else {
//            // we didn't find the shelf
//            throw new RuntimeException("Did not find shelf id - " + theId);
//        }
//
//        return shelfDTO;
    }

    @Override
    public Shelf save(ShelfDTO theShelf) {
        return shelfRepository.save(new Shelf(theShelf));
    }

    @Override
    public Shelf findShelfByCode(String theCode) {
        return this.shelfRepository.findByShelfCode(theCode).orElseThrow(() -> new RuntimeException("Shelf with code '" + theCode + "' not found"));
    }

    @Override
    public void deleteById(Long theId) {
        shelfRepository.deleteById(theId);
    }

//    public Shelf findByShelfCode(String theCode) {
//        Optional<Shelf> result = Optional.ofNullable(shelfRepository.findShelfByCode(theCode));
//
//        ShelfDTO theShelf;
//
//        if (result.isPresent()) {
//
//            theShelf = new ShelfDTO(result.get()) ;
//        } else {
//            // we didn't find the shelf
//            throw new RuntimeException("Did not find shelf id - " + theCode);
//        }
//
//        return theShelf;
//    }

    @Override
    public Shelf toEntity(ShelfDTO shelfDTO) {
        Shelf shelf = new Shelf(shelfDTO);

//        Warehouse warehouse = this.warehouseService.findById(shelfDTO.getWarehouseId());
//        shelf.setWarehouse(warehouse);
        return shelf;
    }

    @Override
    public List<ShelfDTO> toDtoList(List<Shelf> shelves) {
        List<ShelfDTO> list = new ArrayList<>();
        for (Shelf s : shelves){
            list.add(new ShelfDTO(s));
        }
        return list;
    }
}
