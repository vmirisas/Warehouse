package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById (Long theId);
    void save(ProductDTO theProduct);
    ProductDTO findProductByBarcode(String theBarcode);
    void deleteById(Long theId);
}
