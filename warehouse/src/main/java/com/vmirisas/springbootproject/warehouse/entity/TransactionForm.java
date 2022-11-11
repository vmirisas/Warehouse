package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.TransactionFormDTO;
import com.vmirisas.springbootproject.warehouse.entity.enums.FormType;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private FormType type;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

//    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "transactionForm",
            cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<FormDetail> formDetailList;


    public TransactionForm(TransactionFormDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
