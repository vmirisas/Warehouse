package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.Product;
import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import com.vmirisas.springbootproject.warehouse.entity.Stock;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class StockDTO {

    private Long stockId;

//    private Long productId;
    private String barcode;

//    private Long shelfId;
//    @JsonIgnore
    private String shelfCode;

    private int quantity;
    private Date date;

    public StockDTO(Stock stock) {
        BeanUtils.copyProperties(stock, this);

        Product product = stock.getProduct();
//        this.productId = product.getProductId();
        this.barcode = product.getBarcode();

        Shelf shelf = stock.getShelf();
//        this.shelfId = shelf.getShelfId();
        this.shelfCode = shelf.getShelfCode();


    }
}
