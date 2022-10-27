package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.FormDetail;
import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TransactionFormDTO {

    private Long id;
    private String type;
    private Date date;
    private String description;
    private List<FormDetail> formDetails;

    public TransactionFormDTO(TransactionForm transactionForm) {
        BeanUtils.copyProperties(transactionForm, this);
    }
}
