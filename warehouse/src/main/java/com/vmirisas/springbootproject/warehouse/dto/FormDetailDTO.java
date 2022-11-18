package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.FormDetail;
import com.vmirisas.springbootproject.warehouse.entity.Product;
import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;
import com.vmirisas.springbootproject.warehouse.entity.enums.ProductMeasurementUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
public class FormDetailDTO {

    private Long formDetailId;
    private Long transactionFormId;

//    private Long shelfId;
    private String shelfCode;

//    private Long productId;
    private String productDescription;
    private String barcode;
    private ProductMeasurementUnit productUnit;

    private int quantity;

    public FormDetailDTO(FormDetail formDetail) {
        BeanUtils.copyProperties(formDetail, this);

        TransactionForm form = formDetail.getTransactionForm();
        this.transactionFormId = form.getTransactionFormId();

        Shelf shelf = formDetail.getShelf();
//        this.shelfId = shelf.getShelfId();
        this.shelfCode = shelf.getShelfCode();

        Product product = formDetail.getProduct();
//        this.productId = product.getProductId();
        this.productDescription = product.getDescription();
        this.barcode = product.getBarcode();
        this.productUnit = product.getUnit();
    }

}
