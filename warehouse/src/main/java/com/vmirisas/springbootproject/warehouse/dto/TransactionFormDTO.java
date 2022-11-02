package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
public class TransactionFormDTO {

    private Long transactionFormId;
    private String type;
//    private Date date;
    private String description;
//    private List<FormDetail> formDetailList;

    public TransactionFormDTO(TransactionForm transactionForm) {
        BeanUtils.copyProperties(transactionForm, this);
    }
}
