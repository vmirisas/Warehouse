package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.ProductDTO;
import com.vmirisas.springbootproject.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/product/{productId}")
    public ProductDTO getProduct(@PathVariable Long productId) {

        ProductDTO theProduct = productService.findById(productId);

        if(theProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }

        return theProduct;
    }

    @PostMapping("/product")
    public ProductDTO addProduct(@RequestBody ProductDTO theProduct) {
        // also just in case the pass an ID in JSON ... set id to null

        theProduct.setId(0L);

        productService.save(theProduct);

        return theProduct;
    }

    @PutMapping("/product")
    public ProductDTO updateProduct(@RequestBody ProductDTO theProduct) {

        productService.save(theProduct);

        return theProduct;
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProduct(@PathVariable Long productId) {

        ProductDTO tempProduct = productService.findById(productId);

        if (tempProduct == null) {

            throw new RuntimeException("Product id not found - " + productId);
        }

        productService.deleteById(productId);

        return "Deleted product id - " + productId;
    }
}
