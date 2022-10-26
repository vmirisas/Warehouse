package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.ShelfDTO;
import com.vmirisas.springbootproject.warehouse.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShelfRestController {

    @Autowired
    private ShelfService shelfService;

    @GetMapping("/shelf")
    public List<ShelfDTO> findAll() {
        return shelfService.findAll();
    }

    @GetMapping("/shelf/{shelfId}")
    public ShelfDTO getShelf(@PathVariable Long shelfId) {

        ShelfDTO theShelf = shelfService.findById(shelfId);

        if(theShelf == null) {
            throw new RuntimeException("Shelf id not found - " + shelfId);
        }

        return theShelf;
    }

    @PostMapping("/shelf")
    public ShelfDTO addShelf(@RequestBody ShelfDTO theShelf) {
        // also just in case the pass an ID in JSON ... set id to null

        theShelf.setId(0L);

        shelfService.save(theShelf);

        return theShelf;

    }

    @PutMapping("/shelf")
    public ShelfDTO updateShelf(@RequestBody ShelfDTO theShelf) {

        shelfService.save(theShelf);

        return theShelf;
    }

    @DeleteMapping("/shelf/{shelfId}")
    public String deleteShelf(@PathVariable Long shelfId) {

        ShelfDTO tempShelf = shelfService.findById(shelfId);

        if (tempShelf == null) {

            throw new RuntimeException("Shelf id not found - " + shelfId);
        }

        shelfService.deleteById(shelfId);

        return "Deleted shelf id - " + shelfId;
    }
}
