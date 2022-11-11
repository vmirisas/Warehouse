package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.ShelfDTO;
import com.vmirisas.springbootproject.warehouse.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelf")
public class ShelfRestController {

    @Autowired
    private ShelfService shelfService;

    @GetMapping("")
    public List<ShelfDTO> findAll() {
        return this.shelfService.toDtoList(this.shelfService.findAll());
    }

    @GetMapping("/{shelfId}")
    public ShelfDTO getShelf(@PathVariable Long shelfId) {
        return new ShelfDTO(this.shelfService.findById(shelfId));
    }

    @PostMapping("")
    public ShelfDTO addShelf(@RequestBody ShelfDTO theShelf) {
        theShelf.setShelfId(null);
        return new ShelfDTO(this.shelfService.save(theShelf));
    }

    @PutMapping("")
    public ShelfDTO updateShelf(@RequestBody ShelfDTO theShelf) {
        return new ShelfDTO(this.shelfService.save(theShelf));
    }

    @DeleteMapping("/{shelfId}")
    public String deleteShelf(@PathVariable Long shelfId) {
        shelfService.deleteById(shelfId);
        return "Deleted shelf with id - " + shelfId;
    }
}
