package com.vmirisas.springbootproject.warehouse.dto;

import com.vmirisas.springbootproject.warehouse.entity.FormDetail;
import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;
import com.vmirisas.springbootproject.warehouse.entity.enums.FormType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TransactionFormDTO {

    private Long transactionFormId;
    private FormType type;
    private Date date;
    private String description;
    private List<FormDetailDTO> formDetailList = new ArrayList<>();

    public TransactionFormDTO(TransactionForm transactionForm) {
        BeanUtils.copyProperties(transactionForm, this, "formDetailList");

        for (FormDetail detail : transactionForm.getFormDetailList()) {
            this.formDetailList.add(new FormDetailDTO(detail));
        }
    }
}
