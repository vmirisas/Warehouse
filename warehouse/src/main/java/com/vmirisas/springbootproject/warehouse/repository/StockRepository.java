package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long>, StockRepositoryCustom {

//    @Query("SELECT s.quantity FROM Stock s WHERE s.product.barcode = :barcode AND s.shelf.shelfId = :shelfId AND s.date <= :date ORDER BY s.date DESC LIMIT 1")
//    int lastQuantity(@Param("barcode") String barcode, @Param("shelfId") Long shelfId, @Param("date") Date date);

}
