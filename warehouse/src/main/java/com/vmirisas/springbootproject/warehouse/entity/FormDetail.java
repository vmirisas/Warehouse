package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "form_detail")
public class FormDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long formDetailId;

    @Column(name = "transaction_form_id")
    private Long transactionFormId;

    @Column(name = "shelfCode")
    private String shelfCode;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @Column(name = "barcode")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @Column(name = "id")
    private TransactionForm transactionForm;

    public FormDetail(FormDetailDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
