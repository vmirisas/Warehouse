package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.ProductDTO;
import com.vmirisas.springbootproject.warehouse.entity.Product;
import com.vmirisas.springbootproject.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAll() {
        List <Product> productList = productRepository.findAll();
        List <ProductDTO> productDTOList = new ArrayList<>();


        for (Product product:productList) {
            productDTOList.add(new ProductDTO(product));
        }

        return productDTOList;
    }

    @Override
    public ProductDTO findById(Long theId) {
        Optional<Product> result = productRepository.findById(theId);

        ProductDTO theProduct ;

        if (result.isPresent()) {

            theProduct = new ProductDTO(result.get()) ;
        } else {
            // we didn't find the warehouse
            throw new RuntimeException("Did not find warehouse id - " + theId);
        }

        return theProduct;
    }

    @Override
    public void save(ProductDTO theProduct) {
        productRepository.save(new Product(theProduct));
    }

    @Override
    public void deleteById(Long theId) {
        productRepository.deleteById(theId);
    }
}
