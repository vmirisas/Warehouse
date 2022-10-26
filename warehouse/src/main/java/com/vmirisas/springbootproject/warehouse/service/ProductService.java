package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> findAll();

    public ProductDTO findById (Long theId);
    public void save(ProductDTO theProduct);
    public void deleteById(Long theId);
}
