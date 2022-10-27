package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormDetailRepository extends JpaRepository<Product, Long> {
}
