package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.FormDetail;
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
    private String barcode;
    private int quantity;


    public FormDetailDTO(FormDetail formDetail) {
        BeanUtils.copyProperties(formDetail, this);
    }

}
