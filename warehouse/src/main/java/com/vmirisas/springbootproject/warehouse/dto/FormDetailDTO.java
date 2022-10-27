package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.FormDetail;
import com.vmirisas.springbootproject.warehouse.entity.Product;
import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;
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
    private String shelfCode;
    private Product product;
    private int quantity;
    private TransactionForm transactionForm;

    public FormDetailDTO(FormDetail formDetail) {
        BeanUtils.copyProperties(formDetail, this);
    }

}
