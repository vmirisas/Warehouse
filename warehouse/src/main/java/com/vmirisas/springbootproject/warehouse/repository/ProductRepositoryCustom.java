package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryCustom {

    Product findProductByBarcode(String barcode);
}
