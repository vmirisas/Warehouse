package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.TransactionFormDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction_form")
public class TransactionForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_form_id")
    private Long transactionFormId;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private Date date;

    @Column(name = "details")
    private String details;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @Column(name = "form_detail_id")
    private List <FormDetail> formDetailList;

    public TransactionForm(TransactionFormDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
