package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.ProductDTO;
import com.vmirisas.springbootproject.warehouse.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById (Long theId);
    Product save(ProductDTO theProduct);
    Product findProductByBarcode(String theBarcode);
    void deleteById(Long theId);
    List<ProductDTO> toDtoList(List<Product> products);
}
