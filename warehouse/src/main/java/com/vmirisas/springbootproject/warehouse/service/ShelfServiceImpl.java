package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.ShelfDTO;
import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import com.vmirisas.springbootproject.warehouse.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShelfServiceImpl implements ShelfService{

    @Autowired
    private ShelfRepository shelfRepository;

    @Override
    public List<ShelfDTO> findAll() {
        List <Shelf> shelvesList = shelfRepository.findAll();
        List <ShelfDTO> shelvesDTOList = new ArrayList<>();


        for (Shelf shelf:shelvesList) {
            ShelfDTO shelfDTO = new ShelfDTO(shelf);
            shelfDTO.setWarehouseId(shelf.getWarehouse().getWarehouseId());
            shelvesDTOList.add(shelfDTO);
        }

        return shelvesDTOList;
    }

    @Override
    public ShelfDTO findById(Long theId) {
        Optional<Shelf> result =shelfRepository.findById(theId);

        ShelfDTO theShelf ;

        if (result.isPresent()) {

            theShelf = new ShelfDTO(result.get()) ;
        } else {
            // we didn't find the shelf
            throw new RuntimeException("Did not find shelf id - " + theId);
        }

        return theShelf;
    }

    @Override
    public void save(ShelfDTO theShelf) {
        shelfRepository.save(new Shelf(theShelf));
    }

    @Override
    public void deleteById(Long theId) {
        shelfRepository.deleteById(theId);
    }


}
