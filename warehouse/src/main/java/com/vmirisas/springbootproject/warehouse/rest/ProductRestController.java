package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.ProductDTO;
import com.vmirisas.springbootproject.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductDTO> findAll() {
        return this.productService.toDtoList(this.productService.findAll());
    }

    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable Long productId) {
        return new ProductDTO(this.productService.findById(productId));
    }

    @PostMapping("")
    public ProductDTO addProduct(@RequestBody ProductDTO theProduct) {
        theProduct.setProductId(null);
        return new ProductDTO(this.productService.save(theProduct));
    }

    @PutMapping("")
    public ProductDTO updateProduct(@RequestBody ProductDTO theProduct) {
        return new ProductDTO(this.productService.save(theProduct));
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        productService.deleteById(productId);
        return "Deleted product with id '" + productId + "'";
    }
}
